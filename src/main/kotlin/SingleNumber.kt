import java.util.*

fun main() {
    val solution  = SingleNumber()
    println(solution.singleNumber(intArrayOf(2,2,1)))
}

class SingleNumber {
    var s = Stack<Int>()
    fun singleNumber(nums: IntArray): Int {
        nums.sort()

        for (n in nums) {
            if (s.size > 0) {
                val front = s.pop()
                if (front != n) {
                    return front
                }
            } else {
                s.push(n)
            }
        }

        return s.pop()
    }
}