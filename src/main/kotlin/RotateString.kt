fun main() {
    val solution = RotateString()
    println(solution.rotateString("abcde", "abced"))
}

class RotateString {
    fun rotateString(s: String, goal: String): Boolean {
        var str = s
        for (i in 1 until s.length) {
            var tempFront = str.substring(1, s.length)
            tempFront = "${tempFront}${str[0]}"
            if (tempFront == goal) return true
            str = tempFront
        }

        return false
    }
}