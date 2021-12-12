import java.lang.Integer.min
import java.lang.Integer.max

fun main() {
    val solution  = ContainerWithMostWater()
    println(solution.maxArea(intArrayOf(1,2,3,4)))
}

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        var s = 0
        var e = height.size -1
        var result = 0

        while (s < e) {
            result = max(min(height[s], height[e]) * (e-s), result)

            if (height[s] > height[e]) {
                e--
            } else {
                s++
            }
        }

        return result
    }
}