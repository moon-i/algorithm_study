fun main() {
    val solution = RemoveElement()
    println(solution.removeElement(intArrayOf(0,1,2,2,3,0,4,2), 2))
}

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var inputIndex = 0
        for (i in 0 until nums.size) {
            if (nums[i] != `val`) {
                nums[inputIndex] = nums[i]
                inputIndex++
            }
        }

        return inputIndex
    }
}