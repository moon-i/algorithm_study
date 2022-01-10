fun main() {
    val solution = MonotonicArray()
    print(solution.isMonotonic(intArrayOf(1, 1, 2)))
}

class MonotonicArray {
    fun isMonotonic(nums: IntArray): Boolean {
        if (nums.size == 1) return true

        var type = -1 // -1 안정해짐 / 0 dec / 1 inc

        var previous = nums[0]
        nums.map { v ->
            if (type == 1) {
                if (v >= previous) {
                    previous = v
                } else {
                    return false
                }
            } else if (type == 0) {
                if (v <= previous) {
                    previous = v
                } else {
                    return false
                }
            } else {
                if (v < previous) {
                    type = 0
                } else if (v > previous) {
                    type = 1
                }
                previous = v
            }
        }
        return true
    }
}