fun main() {
    val solution = SingleNumber2()
    println(solution.singleNumber(intArrayOf(0,1,0,1,0,1,99)))
}

class SingleNumber2 {
    fun singleNumber(nums: IntArray): Int {
        val hm: HashMap<Int, Int> = HashMap()
        nums.map { n ->
            hm[n]?.let { v ->
                if (v == 2) {
                    hm.remove(n)
                } else {
                    hm[n] = v + 1
                }
            } ?: run {
                hm.put(n, 1)
            }
        }
        return hm.keys.first()
    }
}