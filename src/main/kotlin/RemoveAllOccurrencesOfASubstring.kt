
fun main() {
    val solution = RemoveAllOccurrencesOfASubstring()
    print(solution.removeOccurrences(
        "daabcbaabcbc",
        "abc"
    ))
}

class RemoveAllOccurrencesOfASubstring {
    fun removeOccurrences(s: String, part: String): String {
        var tempString = s
        while (true) {
            var index = tempString.indexOf(part)
            if (index == -1) break

            tempString = "${tempString.substring(0, index)}${tempString.substring(index+part.length, tempString.length)}"
        }

        return tempString
    }
}