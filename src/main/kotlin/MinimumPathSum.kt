import java.util.*

fun main() {
    val solution  = MinimumPathSum()
    println(solution.minPathSum(arrayOf(intArrayOf(1,2,3), intArrayOf(4,5,6))))
}

class MinimumPathSum {
    var q: Queue<Node> = LinkedList<Node>()
    data class Node(
        var x: Int,
        var y: Int,
        var sum: Int
    )
    var dir: Array<Array<Int>> = arrayOf(arrayOf(0, 1), arrayOf(1, 0))

    fun minPathSum(grid: Array<IntArray>): Int {
        if (grid.size == 1 && grid[0].size == 1) return grid[0][0]

        val visitMap = Array<IntArray>(grid.size) { IntArray(grid[grid.size - 1].size) { Int.MAX_VALUE } }
        q.clear()
        q.add(Node(0, 0, grid[0][0]))

        while (!q.isEmpty()) {
            var front = q.element()
            q.remove()

            for (d in dir) {
                val nX = front.x + d[0]
                val nY = front.y + d[1]

                if (nX < grid.size && nY < grid[grid.size - 1].size) {
                    if (visitMap[nX][nY] > front.sum + grid[nX][nY]) {
                        q.add(Node(nX, nY, front.sum + grid[nX][nY]))
                        visitMap[nX][nY] = front.sum + grid[nX][nY]
                    }
                }
            }
        }
        return visitMap[grid.size -1][grid[grid.size-1].size -1]
    }
}