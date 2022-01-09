fun main() {
    val solution = JumpGame3()
    println(solution.canReach(intArrayOf(4,2,3,0,3,1,2), 0))
}

class JumpGame3 {
    lateinit var _arr: IntArray
    lateinit var visit: MutableList<Boolean>
    var result = false
    fun canReach(arr: IntArray, start: Int): Boolean {
        _arr = arr
        visit = MutableList(arr.size) { false }

        visit[start] = true
        dfs(start)

        return result
    }

    fun dfs(newPosition: Int) {
        if (result) return

        if (_arr[newPosition] == 0) {
            result = true
            return
        }

        var newPosition1 = newPosition + _arr[newPosition]
        if (newPosition1 >= 0 && newPosition1 < _arr.size) {
            if (!visit[newPosition1]) {
                visit[newPosition1] = true
                dfs(newPosition1)
                visit[newPosition1] = false
            }
        }

        var newPosition2 = newPosition - _arr[newPosition]
        if (newPosition2 >= 0 && newPosition2 < _arr.size) {
            if (!visit[newPosition2]) {
                visit[newPosition2] = true
                dfs(newPosition2)
                visit[newPosition2] = false
            }
        }
    }
}