fun main() {
    val solution  = LetterCombinationsOfAPhoneNumber()
    println(solution.letterCombinations("23"))
}
class LetterCombinationsOfAPhoneNumber {
    lateinit var result: MutableList<String>
    val mapper = arrayOf(
        arrayOf("a", "b", "c"),
        arrayOf("d", "e", "f"),
        arrayOf("g", "h", "i"),
        arrayOf("j", "k", "l"),
        arrayOf("m", "n", "o"),
        arrayOf("p", "q", "r", "s"),
        arrayOf("t", "u", "v"),
        arrayOf("w", "x", "y", "z"),
    )
    var _digits = ""
    fun letterCombinations(digits: String): List<String> {
        result = mutableListOf()
        _digits = digits
        dfs(0, "")

        return result.toList()
    }

    fun dfs(index: Int, sumString: String) {
        if (index == _digits.length) {
            if (sumString.isNotEmpty()) {
                result.add(sumString)
            }
            return
        }

        for (s in mapper[_digits[index] - '2']) {
            dfs(index + 1, "${sumString}$s")
        }
    }
}