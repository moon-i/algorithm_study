import java.util.*

fun main() {
    val solution = KeyAndRooms()
    print(solution.canVisitAllRooms(
        listOf(
            listOf(1),
            listOf(2),
            listOf(3),
            listOf(),
        )
    ))
}

class KeyAndRooms {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visite = MutableList<Boolean>(rooms.size) { false }

        val queue: Queue<Int> = LinkedList()
        for (i in rooms[0]) queue.add(i)
        visite[0] = true

        while (!queue.isEmpty()) {
            var e = queue.peek()
            queue.remove()

            if (!visite[e]) {
                visite[e] = true
                for(nItem in rooms[e]) queue.add(nItem)
            }
        }

        for (v in visite) if (!v) return false
        return true
    }
}