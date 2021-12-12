fun main() {
    val solution = RotateImage()
    val params = arrayOf(intArrayOf(1, 2, 3), intArrayOf(4, 5, 6), intArrayOf(7, 8, 9))
    solution.rotate(params)
}
class RotateImage {
    fun rotate(matrix: Array<IntArray>): Unit {
        val tmpMap = Array<IntArray>(matrix.size) { intArrayOf() }
        matrix.mapIndexed { i, l ->
            val tempList = IntArray(matrix.size)
            for (j in l.indices) {
                tempList[j] = l[j]
            }
            tmpMap[i] = tempList
        }

        for (i in 0 until  matrix.size) {
            for (j in 0 until matrix[i].size) {
                matrix[i][j] = tmpMap[(matrix.size - 1) - j][i]
            }
        }
    }
}