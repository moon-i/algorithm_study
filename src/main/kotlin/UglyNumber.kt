fun main() {
    val solution = UglyNumber()
    println(solution.isUgly(14))
}

class UglyNumber {
    fun isUgly(n: Int): Boolean {
        var num = n
        while (true) {
            if (num == 1) {
                return true
            }
            if (num == 0) return false
            when {
                (num % 2 == 0) -> {
                    num /=2
                }
                (num % 3 == 0) -> {
                    num /=3
                }
                (num % 5 == 0) -> {
                    num /=5
                }
                else -> {
                    return false
                }
            }
        }

        return false
    }
}