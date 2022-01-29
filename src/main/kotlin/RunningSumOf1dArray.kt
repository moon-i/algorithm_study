fun main() {
    val solution = RunningSumOf1dArray()
    solution.runningSum(intArrayOf(1,2,3,4,5)).map {
        print("$it ")
    }
}

class RunningSumOf1dArray {
    fun runningSum(nums: IntArray): IntArray {
        var result = MutableList<Int>(nums.size) { nums[it] }

        for (i in 1 until nums.size) {
            result[i] += result[i-1]
        }

        return result.toIntArray()
    }
}