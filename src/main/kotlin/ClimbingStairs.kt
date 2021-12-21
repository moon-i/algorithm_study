fun main() {
    val solution = ClimbingStairs()
    println(solution.climbStairs(45))
}

class ClimbingStairs {
    fun climbStairs(n: Int): Int {
        val list = MutableList<Int>(n + 1) { 1 }
        list[1] = 1
        list[2] = 2

        for (i in 3 .. n) {
            // 현재칸은 현재칸 바로 전칸에서 +1 한경우 + 현재칸 전전칸에서 +2 한 경우의 합
            list[i] = list[i-1] + list[i-2]
        }

        return list[n]
    }
}