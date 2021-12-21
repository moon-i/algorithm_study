import java.util.*

fun main() {
    var solution = NumberOfIslands()
    println(solution.numIslands(arrayOf(
        charArrayOf('1','1','0','0','0'),
        charArrayOf('1','1','0','0','0'),
        charArrayOf('0','0','1','0','0'),
        charArrayOf('0','0','0','1','1')
    )))
}

class NumberOfIslands {
    data class Point(
        var x: Int,
        var y: Int
    )
    val dir = arrayOf(
        Point(-1, 0),
        Point(0, -1),
        Point(0, 1),
        Point(1, 0),
    )
    fun numIslands(grid: Array<CharArray>): Int {
        val visiteMap = MutableList<MutableList<Int>>(grid.size) { MutableList(grid[it].size) { 0 } }
        var count = 0
        for (i in 0 until grid.size) {
            for (j in 0 until grid[i].size) {
                if (grid[i][j] == '1' && visiteMap[i][j] == 0) {
                    val q: Queue<Point> = LinkedList()
                    q.add(Point(i, j))
                    count++

                    while (!q.isEmpty()) {
                        val front = q.peek()
                        q.remove()

                        for (d in dir) {
                            val nX = front.x + d.x
                            val nY = front.y + d.y

                            if (nX >= 0 && nX < grid.size && nY >= 0 && nY < grid[i].size) {
                                if (grid[nX][nY] == '1' && visiteMap[nX][nY] == 0) {
                                    visiteMap[nX][nY] = count
                                    q.add(Point(nX, nY))
                                }
                            }
                        }
                    }
                }
            }
        }

        return count
    }
}