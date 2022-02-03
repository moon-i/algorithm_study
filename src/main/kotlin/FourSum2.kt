fun main() {
    val solution = FourSum2()
    print(solution.fourSumCount(
        intArrayOf(-1,-1),
        intArrayOf(-1,1),
        intArrayOf(-1,1),
        intArrayOf(1,-1),
    ))
}

class FourSum2 {
    fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
        var result = 0
        var hm = HashMap<Int, Int>()

        for (i in 0 until nums1.size) {
            for (j in 0 until nums2.size) {
                var tempValue = nums1[i]+ nums2[j]
                hm[tempValue]?.let { v ->
                    hm.put(tempValue, v+1)
                } ?: run {
                    hm.put(tempValue, 1)
                }
            }
        }

        for (k in 0 until nums3.size) {
            for (l in 0 until nums4.size) {
                var tempValue = (nums3[k]+ nums4[l]) * -1
                hm[tempValue]?.let { v ->
                    result += v
                }
            }
        }
        return result
    }
}