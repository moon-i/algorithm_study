fun main() {
    val solution = UniquePaths()
    println(solution.uniquePaths(3, 7))
    // queue로 하면 time limit map 이용하여 각 열 더하기로 해결
}

class UniquePaths {
    fun uniquePaths(m: Int, n: Int): Int {
        val map = MutableList<MutableList<Int>>(m) { MutableList<Int>(n) {1} }

        for (x in 1 until m) {
            for (y in 1 until n) {
                map[x][y] = map[x-1][y] + map[x][y-1]
            }
        }

        return map[m-1][n-1]
    }
}