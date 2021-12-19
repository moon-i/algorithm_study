fun main() {
    val solution = PascalsTriangle()
    solution.generate(5).map { list ->
        list.map { v ->
            print("$v ")
        }
        println()
    }
}

class PascalsTriangle {
    fun generate(numRows: Int): List<List<Int>> {
        val map = MutableList(numRows) { MutableList(it + 1 ) { 0 } }

        for (i in 0 until numRows) {
            map[i][0] = 1
            map[i][i] = 1
        }

        for (i in 1 until numRows) {
            for (j in 1 until i) {
                map[i][j] = map[i-1][j-1] + map[i -1][j]
            }
        }

        return map
    }
}
