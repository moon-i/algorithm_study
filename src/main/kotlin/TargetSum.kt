fun main() {
    val solution = TargetSum()
    print(solution.findTargetSumWays(intArrayOf(1), 1))
}

class TargetSum {
    var returnCount = 0
    var _target = 0
    var result = 0
    lateinit var _nums: IntArray
    fun findTargetSumWays(nums: IntArray, target: Int): Int {
        returnCount = nums.size
        _target = target
        result = 0
        _nums = nums

        dfs(0, 0)

        return result
    }

    fun dfs(sum: Int, count: Int) {
        if (count == returnCount) {
            if (sum == _target) {
                result++
            }
            return
        }

        dfs(sum + _nums[count], count+1)
        dfs(sum - _nums[count], count+1)
    }
}