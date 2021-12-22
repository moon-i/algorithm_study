fun main() {
    val solution = BestTimeToBuyAndSellStock2()
    println(solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
}

class BestTimeToBuyAndSellStock2 {
    fun maxProfit(prices: IntArray): Int {
        var result = 0

        for (i in 0 until prices.size - 1) {
            if (prices[i] < prices[i+1]) {
                result += prices[i+1] - prices[i]
            }
        }

        return result
    }
}