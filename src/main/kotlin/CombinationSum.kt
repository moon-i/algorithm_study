fun main() {
    val solution  = CombinationSum()
    solution.combinationSum(intArrayOf(2, 3, 6, 7), 7).map { list ->
        list.map {
            print(it.toString())
        }
        println()
    }
}

class CombinationSum {
    lateinit var _candidates: IntArray
    lateinit var list: MutableList<Int>
    lateinit var result: MutableList<List<Int>>
    var _target = 0
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        _candidates = candidates
        _target = target
        result = arrayListOf()
        list = arrayListOf()

        dfs(0, 0, list)

        return result.toList()
    }

    fun dfs(sum: Int, startIndex: Int, list: MutableList<Int>) {
        if (sum > _target) {
            return
        }

        if (sum == _target) {
            result.add(list.toList())
            return
        }

        for (i in startIndex until _candidates.size) {
            val tempList = list.toMutableList()
            tempList.add(_candidates[i])
            dfs(sum + _candidates[i], i, tempList)
        }
    }
}