fun main() {
    val solution = Permutations()
    val params = intArrayOf(1, 2, 3)
    solution.permute(params).map {
        it.map { v ->
            print(v)
        }
        println()
    }
}

class Permutations {
    lateinit var visit: MutableList<Boolean>
    lateinit var list: MutableList<Int>
    lateinit var _nums: IntArray
    var result: ArrayList<List<Int>> = ArrayList()
    fun permute(nums: IntArray): List<List<Int>> {
        visit = MutableList(nums.size) {false}
        list = MutableList(nums.size) {0}
        _nums = nums

        dfs(0)

        return result
    }

    fun dfs(index: Int) {
        if (index == _nums.size) {
            result.add(list.toList())
            return
        }
        for (i in _nums.indices) {
            if (!visit[i]) {
                visit[i] = true
                list[index] = _nums[i]
                dfs(index + 1)
                visit[i] = false
            }
        }
    }
}