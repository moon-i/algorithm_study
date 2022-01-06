fun main() {
    val result = IntersectionOfTwoArrays2()
    result.intersect(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).apply {
        map { println("$it ") }
    }
}
class IntersectionOfTwoArrays2 {
    fun intersect(nums1: IntArray, nums2: IntArray): IntArray {
        val hm = HashMap<Int, Int>()
        val result: MutableList<Int> = mutableListOf()

        nums1.map { key ->
            hm[key]?.let{
                hm[key] = it+1
            } ?: run {
                hm.put(key, 1)
            }
        }

        nums2.map { key ->
            hm[key]?.let { count ->
                if (count > 0) {
                    result.add(key)
                    hm[key] = count - 1
                }
            }
        }

        return result.toIntArray()
    }
}