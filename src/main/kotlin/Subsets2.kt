fun main() {
    val solution = Subsets2()
    solution.subsetsWithDup(intArrayOf(4,1,0)).map {
        it.map { print(it) }
        println()
    }
}

class Subsets2 {
    lateinit var _nums: MutableList<Int>
    lateinit var list: MutableList<Int>
    lateinit var result: MutableSet<List<Int>>
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        _nums = MutableList(nums.size) { nums[it] }
        list = mutableListOf()
        result = mutableSetOf()
        _nums.sort()

        dfs(0)

        return result.toList()
    }

    fun dfs(startIndex: Int) {
        result.add(list.toList())

        for (i in startIndex until _nums.size) {
            list.add(_nums[i])
            dfs(i+1)
            list.removeAt(list.size-1)
        }
    }
}