fun main() {
    val solution = PascalsTriangle2()
    solution.getRow(33).map { v ->
        print("$v ")
    }
}

class PascalsTriangle2 {
    lateinit var map: MutableList<MutableList<Int>>
    fun generate(numRows: Int) {
         map = MutableList(numRows) { MutableList(it + 1 ) { 0 } }

        for (i in 0 until numRows) {
            map[i][0] = 1
            map[i][i] = 1
        }

        for (i in 1 until numRows) {
            for (j in 1 until i) {
                map[i][j] = map[i-1][j-1] + map[i -1][j]
            }
        }
    }

    fun getRow(rowIndex: Int): List<Int> {
        generate(rowIndex + 1)

        return map[rowIndex]
    }
}
