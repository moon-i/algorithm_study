
fun main() {
    val solution = LongestSubstringWithoutRepeatingCharacters()
    print(solution.lengthOfLongestSubstring("pwwkew"))
}

class LongestSubstringWithoutRepeatingCharacters {
    fun lengthOfLongestSubstring(s: String): Int {
        var result = 0
        for (i in 0 until s.length) {
            var hashMap = HashMap<Char, Int>()
            var index = 0
            while (true) {
                if (index + i >= s.length) {
                    if (hashMap.size > result) result = hashMap.size
                    break
                }

                if (hashMap[s[i+index]] != null) {
                    if (hashMap.size > result) result = hashMap.size
                    break
                } else {
                    hashMap.put(s[i+index], 0)
                }

                index++
            }
        }

        return result
    }
}