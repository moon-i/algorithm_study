import java.util.*

fun main() {
    val solution = MaxAreaOfIsland()
//    println(solution.maxAreaOfIsland(arrayOf(
//        intArrayOf(0,0,1,0,0,0,0,1,0,0,0,0,0),
//        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
//        intArrayOf(0,1,1,0,1,0,0,0,0,0,0,0,0),
//        intArrayOf(0,1,0,0,1,1,0,0,1,0,1,0,0),
//        intArrayOf(0,1,0,0,1,1,0,0,1,1,1,0,0),
//        intArrayOf(0,0,0,0,0,0,0,0,0,0,1,0,0),
//        intArrayOf(0,0,0,0,0,0,0,1,1,1,0,0,0),
//        intArrayOf(0,0,0,0,0,0,0,1,1,0,0,0,0)
//    )))
    println(solution.maxAreaOfIsland(arrayOf(
        intArrayOf(1,1,0,0,0),
        intArrayOf(1,1,0,0,0),
        intArrayOf(0,0,0,1,1),
        intArrayOf(0,0,0,1,1)
    )))
}

class MaxAreaOfIsland {
    var dir = arrayOf(Pair(1, 0), Pair(0, 1), Pair(-1, 0), Pair(0, -1))
    fun maxAreaOfIsland(grid: Array<IntArray>): Int {
        var m = grid.size
        var n = grid[0].size
        var count = 0
        var visite = MutableList<MutableList<Boolean>>(m) { MutableList<Boolean>(n) { false } }

        for (i in 0 until m) {
            for (j in 0 until n) {
                if (grid[i][j] == 0) {
                    visite[i][j] = true
                } else {
                    if (!visite[i][j]) {
                        var tempCount = 1
                        val q: Queue<Pair<Int, Int>> = LinkedList<Pair<Int, Int>>()
                        q.add(Pair(i, j))

                        while (!q.isEmpty()) {
                            val front = q.peek()
                            q.remove()
                            visite[front.first][front.second] = true
                            for (k in 0 until dir.size) {
                                val nX = front.first + dir[k].first
                                val nY = front.second + dir[k].second

                                if (nX < 0 || nX >= m || nY < 0 || nY >= n) { continue }
                                if (grid[nX][nY] == 1 && !visite[nX][nY]) {
                                    q.add(Pair(nX, nY))
                                    visite[nX][nY] = true
                                    tempCount++
                                }
                            }
                        }
                        if (count < tempCount) {
                            count = tempCount
                        }
                    }
                }
            }
        }
        return count
    }
}