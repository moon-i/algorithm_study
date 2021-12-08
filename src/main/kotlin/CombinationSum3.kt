fun main() {
    val solution  = CombinationSum3()
    solution.combinationSum3(9, 45).map {list ->
        list.map {
            print(it.toString())
        }
        println()
    }
}

class CombinationSum3 {
    lateinit var result: ArrayList<List<Int>>
    lateinit var list: MutableList<Int>
    var _n: Int = 0
    var _k: Int = 0
    fun combinationSum3(k: Int, n: Int): List<List<Int>> {
        result = ArrayList()
        list = MutableList(k) {0}
        _n = n
        _k = k

        dfs(k, 1, 0)

        return result.toList()
    }

    fun dfs(count: Int, nextIndex: Int, sum: Int) {
        if (count == 0) {
            if (sum == _n) {
                result.add(list.toList())
            }
            return
        }

        for (i in nextIndex .. 9) {
            if (sum + i <= _n) {
                list[_k - count] = i
                dfs(count-1, i+1, sum+i)
            }
        }
    }
}
