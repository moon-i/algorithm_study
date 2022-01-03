fun main() {
    val solution = FindAllDuplicatesInAnArray()
    println(solution.findDuplicates(intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)).toString())
}
class FindAllDuplicatesInAnArray {
    fun findDuplicates(nums: IntArray): List<Int> {
        val result: ArrayList<Int> = ArrayList()

        val hm: HashMap<Int, Int> = HashMap()
        nums.map { v ->
            hm[v]?.let {
                hm.remove(v)
                result.add(v)
            } ?: run {
                hm.put(v, 0)
            }
        }

        return result.toList()
    }
}