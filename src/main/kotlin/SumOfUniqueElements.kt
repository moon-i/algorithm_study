fun main() {
    val solution = SumOfUniqueElements()
    println(solution.sumOfUnique(intArrayOf(1,2,3,2)))
}
class SumOfUniqueElements {
    fun sumOfUnique(nums: IntArray): Int {
        val hm: HashMap<Int, Int> = HashMap()
        var result = 0
        nums.map { v ->
            hm.get(v)?.let {
                hm.put(v, it + 1)
            } ?: run {
                hm.put(v, 1)
            }
        }

        for (i in hm.keys) {
            if (hm[i] == 1) {
                result += i
            }
        }
        return result
    }
}