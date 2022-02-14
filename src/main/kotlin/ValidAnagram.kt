fun main() {
    val solution = ValidAnagram()
    println(solution.isAnagram("rat", "car"))
}

class ValidAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        var word1 = MutableList<Int>(26) {0}
        var word2 = MutableList<Int>(26) {0}

        s.map {
            word1[it-'a']++
        }
        t.map {
            word2[it-'a']++
        }

        for (i in 0 until word1.size) {
            if (word1[i] != word2[i]) return false
        }

        return true
    }
}