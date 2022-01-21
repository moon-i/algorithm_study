fun main() {
    val solution = LetterCasePermutation()
    print(solution.letterCasePermutation("a1b2").toString())
}

class LetterCasePermutation {
    var result = ArrayList<String>()
    var _s = ""
    fun letterCasePermutation(s: String): List<String> {
        _s = s
        dfs(0, "")

        return result.toList()
    }

    fun dfs(index: Int, tempString: String) {
        if (index == _s.length) {
            result.add(tempString)
            return
        }

        if (_s[index] - '0' in 0 .. 9) {
            dfs(index+1, "${tempString}${_s[index]}")
        } else {
            if (_s[index].isLowerCase()) {
                dfs(index+1, "${tempString}${_s[index]}")
                dfs(index+1, "${tempString}${(_s[index] - 32)}")
            } else {
                dfs(index+1, "${tempString}${_s[index]}")
                dfs(index+1, "${tempString}${(_s[index] + 32)}")
            }

        }
    }
}