fun main() {
    val solution = IsSubsequence()
    println(solution.isSubsequence("axc", "ahbgdc"))
}

class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        var sIndex = if(s.length > 0) 0 else return true

        t.mapIndexed { i, v ->
            if (v == s[sIndex]) {
                if (sIndex < s.length) {
                    sIndex++
                }
                if (sIndex == s.length) {
                    return true
                }
            }
        }

        return false
    }
}