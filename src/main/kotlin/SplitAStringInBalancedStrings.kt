fun main() {
    val solution = SplitAStringInBalancedStrings()
    println(solution.balancedStringSplit("LLLLRRRR"))
}
class SplitAStringInBalancedStrings {
    fun balancedStringSplit(s: String): Int {
        var count = 0
        var result = 0

        s.map {
            if (it == 'L') {
                count++
            } else {
                count--
            }
            if (count == 0) {
                result++
            }
        }
        return result
    }
}