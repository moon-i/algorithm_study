import java.util.*

fun main() {
    val solution = JumpGame()
    print(solution.canJump(intArrayOf(3, 2, 1, 0, 4)))
}

class JumpGame {
    fun canJump(nums: IntArray): Boolean {
        val visite = MutableList<Boolean>(nums.size) { false }
        val q: Queue<Int> = LinkedList<Int>()
        q.add(0)
        visite[0] = true
        while (!q.isEmpty()) {
            var front = q.peek()
            q.remove()

            for(i in 0 .. nums[front]){
                if (i + front < nums.size && !visite[i + front]) {
                    visite[i + front] = true
                    q.add(i + front)
                }
            }
        }

        return visite[visite.size-1]
    }
}