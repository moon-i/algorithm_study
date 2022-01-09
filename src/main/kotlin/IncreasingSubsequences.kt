fun main() {
    val solution  = IncreasingSubsequences()
    solution.findSubsequences(intArrayOf(4, 6, 7, 7)).map { list ->
        list.map {
            print(it.toString())
        }
        println()
    }
}

class IncreasingSubsequences {
    var result: MutableSet<List<Int>> = mutableSetOf()
    lateinit var _nums: IntArray
    lateinit var tempList: MutableList<Int>
    fun findSubsequences(nums: IntArray): List<List<Int>> {
        tempList = mutableListOf()
        _nums = nums

        dfs(0, 0, -101)
        return result.toList()
    }

    fun dfs(count: Int, nextIndex: Int, currentNum: Int) {
        if (count >= 2) {
            result.add(tempList.toList())
        }

        for (i in nextIndex until _nums.size) {
            if (currentNum <= _nums[i]) {
                tempList.add(_nums[i])
                dfs(count+1, i+1, _nums[i])
                tempList.removeAt(tempList.size - 1)
            }
        }
    }
}