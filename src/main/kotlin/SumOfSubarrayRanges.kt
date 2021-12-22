fun main() {
    val solution  = SumOfSubarrayRanges()
    println(solution.subArrayRanges(intArrayOf(4, -2, -3, 4, 1)))
}

class SumOfSubarrayRanges {
    data class Pair(
        var largest: Int,
        var smallest: Int
    )

    fun subArrayRanges(nums: IntArray): Long {
        var result = 0L
        val map = MutableList<MutableList<Pair>>(nums.size) { MutableList(nums.size) { Pair(nums[it], nums[it]) } }

        for (i in 1 until nums.size) {
            for (j in i until nums.size) {
                if (map[i-1][j-1].largest > map[i-1][j].largest) {
                    map[i][j].largest = map[i-1][j-1].largest
                } else {
                    map[i][j].largest = map[i-1][j].largest
                }

                if (map[i-1][j-1].smallest < map[i-1][j].smallest) {
                    map[i][j].smallest = map[i-1][j-1].smallest
                } else {
                    map[i][j].smallest = map[i-1][j].smallest
                }

                result += map[i][j].largest - map[i][j].smallest
            }
        }

        return result
    }
}