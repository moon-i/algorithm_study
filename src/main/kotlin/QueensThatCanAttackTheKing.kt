import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val solution = QueensThatCanAttackTheKing()
    println(solution.queensAttacktheKing(arrayOf(
        intArrayOf(0,1),
        intArrayOf(1,0),
        intArrayOf(4,0),
        intArrayOf(3,3),
        intArrayOf(2,4),
    ), intArrayOf(0,0)).toString())
}

class QueensThatCanAttackTheKing {
    fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
        var result = ArrayList<List<Int>>()
        var dir = arrayOf(
            arrayOf(0, 1),
            arrayOf(1, 0),
            arrayOf(1, 1),
            arrayOf(0, -1),
            arrayOf(-1, 0),
            arrayOf(-1, -1),
            arrayOf(1, -1),
            arrayOf(-1, 1)
        )

        var map = MutableList<MutableList<Boolean>>(8) { MutableList(8) {false} }
        queens.map {
            map[it[0]][it[1]] = true
        }

        for (i in 0 until 8) {
            val queue: Queue<IntArray> = LinkedList()
            queue.add(king)
            while (!queue.isEmpty()) {
                var front = queue.peek()
                queue.remove()

                var nX = front[0] + dir[i][0]
                var nY = front[1] + dir[i][1]

                if (nX >= 0 && nX < 8 && nY >= 0 && nY <8)  {
                    if (map[nX][nY]) {
                        result.add(intArrayOf(nX, nY).toList())
                        break
                    }
                    queue.add(intArrayOf(nX, nY))
                }
            }
        }

        return result.toList()
    }
}