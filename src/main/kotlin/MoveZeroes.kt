fun main() {
    val solution = MoveZeroes()
    val params = intArrayOf(0, 1, 0, 3, 12)
    solution.moveZeroes(params)
    params.map { v -> print(v) }
}

class MoveZeroes {
    fun moveZeroes(nums: IntArray): Unit {
        var indexWrite = 0
        nums.map { v ->
            if (v != 0) {
                nums[indexWrite++] = v
            }
        }
        for (i in indexWrite until nums.size) {
            nums[i] = 0
        }
    }
}
