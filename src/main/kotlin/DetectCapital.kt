
fun main() {
    val solution  = DetectCapital()
    println(solution.detectCapitalUse("FlaG"))
}
class DetectCapital {
    fun detectCapitalUse(word: String): Boolean {
        var isAllUpper = false
        var isAllLower = false
        var isFirstWordUpper = false

        for (i in 0 until word.length) {
            if (i == 0) {
                if (word[i].isLower()) isAllLower = true
                if (word[i].isUpper()) {
                    isAllUpper = true
                    isFirstWordUpper = true
                }
            } else {
                if (isFirstWordUpper && word[i].isUpper()) isFirstWordUpper = false
                if (isAllUpper && word[i].isLower()) isAllUpper = false
                if (isAllLower && word[i].isUpper()) isAllLower = false
            }
        }

        return isAllLower || isAllUpper || isFirstWordUpper
    }

    fun Char.isUpper(): Boolean {
        return this in 'A'..'Z'
    }

    fun Char.isLower(): Boolean {
        return this in 'a'..'z'
    }
}