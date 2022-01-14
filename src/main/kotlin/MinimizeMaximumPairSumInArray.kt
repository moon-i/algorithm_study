fun main() {
    val solution = MinimizeMaximumPairSumInArray()
    println(solution.minPairSum(intArrayOf(3,5,4,2,4,6)))
}
class MinimizeMaximumPairSumInArray {
    fun minPairSum(nums: IntArray): Int {
        val _nums = MutableList(nums.size) { nums[it] }
        _nums.sort()
        var maxResult = 0

        var startIndex = 0
        var endIndex = nums.size - 1
        while (startIndex < endIndex) {
            var temp = _nums[startIndex] + _nums[endIndex]
            if (maxResult < temp) {
                maxResult = temp
            }

            startIndex++
            endIndex--
        }

        return maxResult
    }
}