
fun main() {
    val solution = SpiralMatrix()
    println(solution.spiralOrder(
        arrayOf(
            intArrayOf(1,2,3,4),
            intArrayOf(5,6,7,8),
            intArrayOf(9,10,11,12)
        )
    ).toString())
}

class SpiralMatrix {
    val dir = arrayOf(arrayOf(0, 1), arrayOf(1, 0), arrayOf(0, -1), arrayOf(-1, 0))
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        var visite = MutableList<MutableList<Boolean>>(matrix.size) { MutableList<Boolean>(matrix[it].size) { false } }
        var result = MutableList<Int>(1) { matrix[0][0] }

        var x = matrix.size
        var y = matrix[0].size

        visite[0][0] = true

        var currentDir = 0
        var cX = 0
        var cY = 0

        while (true) {
            if (result.size == x*y) break

            var nX = cX + dir[currentDir][0]
            var nY = cY + dir[currentDir][1]

            if (nX < 0 || nX >= x || nY < 0 || nY >= y || visite[nX][nY]) {
                currentDir = (currentDir + 1) % 4
            } else {
                result.add(matrix[nX][nY])
                visite[nX][nY] = true
                cX = nX
                cY = nY
            }
        }

        return result.toList()
    }
}