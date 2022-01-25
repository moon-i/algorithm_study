
fun main() {
    val solution = ValidMountainArray()
    println(solution.validMountainArray(intArrayOf(0,2,3,3,5,2,1,0)))
}

class ValidMountainArray {
    fun validMountainArray(arr: IntArray): Boolean {
        var requireState = 1 // 1: 올라가야하는 상황 0: 꺾여야하는상황 -1: 내려가야하는상황 //  현재 요구되는 state
        var preNum = arr[0]
        for (i in 1 until arr.size) {
            when(requireState) {
                1 -> {
                    if (preNum < arr[i]) {
                        requireState = 0
                        preNum = arr[i]
                    } else {
                        return false
                    }
                }
                0 -> {
                    if (preNum > arr[i]) {
                        requireState = -1
                        preNum = arr[i]
                    } else if (preNum == arr[i]) {
                       return false
                    } else {
                        preNum = arr[i]
                    }
                }
                else -> {
                    if (preNum > arr[i]) {
                        preNum = arr[i]
                    } else {
                        return false
                    }
                }
            }
        }
        return (requireState == -1)
    }
}