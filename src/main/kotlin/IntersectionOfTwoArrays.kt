fun main() {
    val solution = IntersectionOfTwoArrays()
    solution.intersection(intArrayOf(4,9,5), intArrayOf(9,4,9,8,4)).apply {
        map { print("$it ") }
    }
}

class IntersectionOfTwoArrays {
    fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
        val hm = HashMap<Int, Int>()
        val resultSet: MutableSet<Int> = mutableSetOf()

        nums1.map {
            hm[it] ?: run { hm.put(it, it) }
        }

        nums2.map {
            hm[it]?.let {
                resultSet.add(it)
            }
        }

        return resultSet.toIntArray()
    }
}