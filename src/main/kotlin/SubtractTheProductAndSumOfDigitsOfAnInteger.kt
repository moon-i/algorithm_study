
fun main() {
    val solution = SubtractTheProductAndSumOfDigitsOfAnInteger()
    print(solution.subtractProductAndSum(4421))
}

class SubtractTheProductAndSumOfDigitsOfAnInteger {
    fun subtractProductAndSum(n: Int): Int {
        var _n = n
        var num = if (n.toString().length == 1) 1 else {
            var temp = 1
            for (i in 1 until n.toString().length) { temp *= 10 }
            temp
        }

        var sumResult = 0
        var multipleResult = 1
        while (true) {
            var temp = _n / num
            sumResult += temp
            multipleResult *= temp

            _n %= num
            if (num == 1) break
            num /= 10
        }

        return multipleResult - sumResult
    }
}