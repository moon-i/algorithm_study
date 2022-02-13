fun main() {
    val solution = MergeIntervals()
    solution.merge(arrayOf(intArrayOf(1,4),
        intArrayOf(2, 3),
//        intArrayOf(8, 10),
//        intArrayOf(15, 18),
    )).map {
        it.map { print(it) }
        println()
    }
}

class MergeIntervals {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortBy { it[0] }
        var result = ArrayList<IntArray>()
        var front = intervals[0]
        for (i in 1 until intervals.size) {
            if (front[1] >= intervals[i][0]) {
                var start = if (front[0] < intervals[i][0]) front[0] else intervals[i][0]
                var end = if (front[1] > intervals[i][1]) front[1] else intervals[i][1]
                front = intArrayOf(start, end)
            } else {
                result.add(front)
                front = intervals[i]
            }
        }
        result.add(front)

        return result.toTypedArray()
    }
}