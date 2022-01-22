
fun main() {
    val solution  = CountNumberOfTeams()
    println(solution.numTeams(intArrayOf(1, 2, 3, 4)))
}

class CountNumberOfTeams {
    fun numTeams(rating: IntArray): Int {
        var result = 0

        for (i in 0 until rating.size - 2) {
            for (j in i + 1 until rating.size - 1) {
                for (k in j + 1 until rating.size) {
                    if (rating[i] < rating[j]  && rating[j] < rating[k]) result++
                    if (rating[i] > rating[j]  && rating[j] > rating[k]) result++
                }
            }
        }

        return result
    }
}