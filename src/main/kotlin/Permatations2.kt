fun main() {
    val solution = Permatations2()
    val params = intArrayOf(1, 1, 2)
    solution.permuteUnique(params).map {
        it.map { v ->
            print(v)
        }
        println()
    }
}

class Permatations2 {
    lateinit var hm: HashMap<List<Int>, Int>
    lateinit var visite: MutableList<Boolean>
    lateinit var _n: IntArray
    lateinit var list: MutableList<Int>
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        _n = nums
        visite = MutableList(nums.size) { false }
        hm = HashMap()
        list = MutableList(nums.size) { 0 }

        dfs(0)

        val result = ArrayList<List<Int>>()
        for (k in hm.keys) {
            result.add(k)
        }
        return result.toList()
    }

    fun dfs(count: Int) {
        if (count == _n.size) {
            if (hm[list.toList()] == null) {
                hm[list.toList()] = 1
            }
            return
        }

        for (i in 0 until _n.size) {
            if (!visite[i]) {
                visite[i] = true
                list[count] = _n[i]
                dfs(count+1)
                visite[i] = false
            }
        }
    }
}