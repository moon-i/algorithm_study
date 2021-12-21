fun main() {
    val solution = BestTimeToBuyAndSellStock()
    println(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

class BestTimeToBuyAndSellStock {
    fun maxProfit(prices: IntArray): Int {
        var result = 0

        var minBefore = prices[0]
        for (currentIndex in 1 until prices.size) {
            if (prices[currentIndex] - minBefore > result) {
                result = prices[currentIndex] - minBefore
            }
            if (minBefore > prices[currentIndex]) {
                minBefore = prices[currentIndex]
            }
        }

        return result
    }
}