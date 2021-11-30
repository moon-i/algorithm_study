
fun main() {
    val solution = Combinations()
    println(solution.combine(4, 2))
}

class Combinations {
    lateinit var answerList: MutableList<Int>
    var answer = ArrayList<List<Int>>()
    var _k = -1
    var _n = -1
    fun combine(n: Int, k: Int): List<List<Int>> {
        answerList = MutableList(k){0}
        _k = k
        _n = n

        dfs(1, 0)

        return answer.toList()
    }

    fun dfs(startIndex: Int, count: Int) {
        if (count == _k) {
            answer.add(answerList.toList())
            return
        }

        for (i in startIndex .. _n) {
            answerList[count] = i
            dfs(i+1, count+1)
        }
    }
}