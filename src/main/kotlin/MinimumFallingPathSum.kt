fun main() {
    val solution = MinimumFallingPathSum()
    print(solution.minFallingPathSum(arrayOf(
        intArrayOf(2,1,3),
        intArrayOf(6,5,4),
        intArrayOf(7,8,9),
    )))
}

class MinimumFallingPathSum {
    fun minFallingPathSum(matrix: Array<IntArray>): Int {
        var newMatrix =
            Array<MutableList<Int>>(matrix.size) { i -> MutableList<Int>(matrix[i].size) { j -> matrix[i][j] } }

        for (i in 1 until matrix.size) {
            for (j in 0 until matrix[i].size) {
                var min = Int.MAX_VALUE
                if (j - 1 >= 0) {
                    if (min > newMatrix[i-1][j-1]) min = newMatrix[i-1][j-1]
                }
                if (min > newMatrix[i-1][j]) min = newMatrix[i-1][j]
                if (j + 1 < matrix[i].size) {
                    if (min > newMatrix[i-1][j+1]) min = newMatrix[i-1][j+1]
                }
                newMatrix[i][j] += min
            }
        }

        var result = Int.MAX_VALUE
        newMatrix[matrix.size-1].map {
            if (it < result) {
                result = it
            }
        }

        return result
    }
}