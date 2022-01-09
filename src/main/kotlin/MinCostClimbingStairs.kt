import kotlin.math.min

fun main() {
    val solution = MinCostClimbingStairs()
    println(solution.minCostClimbingStairs(intArrayOf(1,100,1,1,1,100,1,1,100,1)))
}

class MinCostClimbingStairs {
    fun minCostClimbingStairs(cost: IntArray): Int {
        var resultArray = MutableList<Int>(cost.size + 1) { Int.MAX_VALUE }
        var _cost = MutableList<Int>(cost.size + 1) { 0 }
        cost.mapIndexed { i, v ->
            _cost[i] = v
        }

        resultArray[0] = _cost[0]
        resultArray[1] = _cost[1]

        for (i in 2 until _cost.size) {
            resultArray[i] = _cost[i] + min(resultArray[i-1], resultArray[i-2])
        }

        return resultArray[resultArray.size-1]
    }
}