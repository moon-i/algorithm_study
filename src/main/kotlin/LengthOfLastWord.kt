fun main() {
    val solution = LengthOfLastWord()
    println(solution.lengthOfLastWord("Hello World"))
}

class LengthOfLastWord {
    fun lengthOfLastWord(s: String): Int {
        val stringArray = s.split(" ").filter { it != "" }

        return stringArray[stringArray.size-1].length
    }
}