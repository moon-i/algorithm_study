import kotlin.math.abs

fun main() {
    val solution  = CountGoodTriplets()
    println(solution.countGoodTriplets(intArrayOf(1,1,2,2,3), 0, 0, 1))
}

class CountGoodTriplets {
    fun countGoodTriplets(arr: IntArray, a: Int, b: Int, c: Int): Int {
        var result = 0
        for (i in 0 until arr.size - 2) {
            for (j in i + 1 until arr.size - 1) {
                for (k in j + 1 until arr.size) {
                    var tempResult = 0
                    if (abs(arr[i] - arr[j]) <= a) {tempResult++}
                    if (abs(arr[j] - arr[k]) <= b) {tempResult++}
                    if (abs(arr[i] - arr[k]) <= c) {tempResult++}
                    if (tempResult == 3) result++
                }
            }
        }

        return result
    }
}