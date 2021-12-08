fun main() {
    val solution = Subsets()
    val params = intArrayOf(1, 2, 3)
    solution.subsets(params).map {
        it.map { v ->
            print(v)
        }
        println()
    }
}

class Subsets {
    lateinit var visite: MutableList<Boolean>
    lateinit var list: MutableList<Int>
    lateinit var resultList: ArrayList<List<Int>>
    lateinit var _nums: IntArray
    fun subsets(nums: IntArray): List<List<Int>> {
        visite = MutableList<Boolean>(nums.size) { false }
        resultList = ArrayList()
        _nums = nums
        for (i in 0..nums.size) {
            list = MutableList<Int>(i) { 0 }
            dfs(i, 0, 0)
        }

        return resultList.toList()
    }

    /**
     * count: 더 추가할 요소의 개수
     * insertIndex: list에 다음 추가할 위치 인덱스 기억
     * next: 현재 선택한 요소의 다음에서부터 for문을 시작하기위한 다음 인덱스 (2,3) (3,2) 중복막기위함
     * */
    fun dfs(count: Int, insertIndex: Int, next: Int) {
        if (count == 0) {
            resultList.add(list.toList())
            return
        }

        for (i in next until _nums.size) {
            if (!visite[i]) {
                visite[i] = true
                list[insertIndex] = _nums[i]
                dfs(count - 1, insertIndex + 1, i + 1)
                visite[i] = false
            }
        }
    }
}