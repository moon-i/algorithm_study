fun main() {
    val solution = NumberOfStepsToReduceANumberToZero()
    println(solution.numberOfSteps(123))
}
class NumberOfStepsToReduceANumberToZero {
    fun numberOfSteps(num: Int): Int {
        var _num = num
        var step = 0

        while (_num != 0) {
            step++
            if (_num % 2 == 0) {
                _num /= 2
            } else {
                _num -= 1
            }
        }
        return step
    }
}