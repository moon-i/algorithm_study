fun main() {
    val solution = Triangle()
    println(solution.minimumTotal(listOf(
        listOf(2),
        listOf(3, 4),
        listOf(6, 5, 7),
        listOf(4, 1, 8, 3)
    )))
}

class Triangle {
    var result = Int.MAX_VALUE
        set(value) {
            if (field > value || value == Int.MAX_VALUE)
                field = value
        }
    fun minimumTotal(triangle: List<List<Int>>): Int {
        result = Int.MAX_VALUE
        val calcMap = MutableList<MutableList<Int>>(triangle.size) { MutableList(triangle[it].size) { Int.MAX_VALUE } }

        calcMap[0][0] = triangle[0][0]
        for (i in triangle.indices) {
            for(j in 0 until triangle[i].size) {
                if (i - 1 >= 0 && j - 1 >= 0) {
                    calcMap[i][j] = triangle[i][j] + calcMap[i-1][j-1]
                }
                if (i - 1 >= 0 && j < triangle[i-1].size && calcMap[i][j] > triangle[i][j] + calcMap[i-1][j]) {
                    calcMap[i][j] = triangle[i][j] + calcMap[i-1][j]
                }
            }
        }

        for (j in calcMap[calcMap.size-1]) {
            result = j
        }

        return result
    }
}