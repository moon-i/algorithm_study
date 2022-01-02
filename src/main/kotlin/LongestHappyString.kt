fun main() {
    val solution = LongestHappyString()
    println(solution.longestDiverseString(7, 1, 0))
}

class LongestHappyString {
    var stringCountArray = MutableList<Int>(3) {0}
    var stringArray = arrayOf("a", "b", "c")
    fun longestDiverseString(a: Int, b: Int, c: Int): String {
        stringCountArray[0] = a
        stringCountArray[1] = b
        stringCountArray[2] = c

        var result = ""
        var combo = 0
        var beforeStringIndex = -1
        while (stringCountArray[0] > 0 || stringCountArray[1] > 0 || stringCountArray[2] > 0) {
            var maxCountIndex = countString()
            if (beforeStringIndex == maxCountIndex) {
                if (combo == 1) {
                    // 잠시 두번째 우선순위 인덱스를 가져온다
                    val tempCount = stringCountArray[maxCountIndex]
                    stringCountArray[maxCountIndex] = 0
                    val secondCountIndex = countString()
                    if (secondCountIndex == -1) {
                        return result // 종료조건 앞으로 연속된 3개의 string만 나올수 있는경우
                    }
                    stringCountArray[maxCountIndex] = tempCount

                    result += stringArray[secondCountIndex]
                    beforeStringIndex = secondCountIndex
                    stringCountArray[secondCountIndex]--
                    combo = 0
                } else {
                    combo++
                    result += stringArray[maxCountIndex]
                    beforeStringIndex = maxCountIndex
                    stringCountArray[maxCountIndex]--
                }
            } else {
                combo = 0
                result += stringArray[maxCountIndex]
                beforeStringIndex = maxCountIndex
                stringCountArray[maxCountIndex]--
            }
        }
        return result
    }

    fun countString(): Int {
        var maxValue = 0
        var maxIndex = 0
        for (index in 0 .. 2) {
            if (maxValue < stringCountArray[index]) {
                maxValue = stringCountArray[index]
                maxIndex = index
            }
        }
        if (maxValue == 0) {
            return -1
        }
        return maxIndex
    }
}