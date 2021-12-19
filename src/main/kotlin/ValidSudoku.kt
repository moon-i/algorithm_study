fun main() {
    var solution = ValidSudoku()
    println(solution.isValidSudoku(arrayOf(
        charArrayOf('8','3','.','.','7','.','.','.','.'),
        charArrayOf('6','.','.','1','9','5','.','.','.'),
        charArrayOf('.','9','8','.','.','.','.','6','.'),
        charArrayOf('8','.','.','.','6','.','.','.','3'),
        charArrayOf('4','.','.','8','.','3','.','.','1'),
        charArrayOf('7','.','.','.','2','.','.','.','6'),
        charArrayOf('.','6','.','.','.','.','2','8','.'),
        charArrayOf('.','.','.','4','1','9','.','.','5'),
        charArrayOf('.','.','.','.','8','.','.','7','9'))
    ))
}
class ValidSudoku {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (c in 0 until 9) {
            val downhaveArray = BooleanArray(10) { false }
            val righthaveArray = BooleanArray(10) { false }
            for (r in 0 until 9) {
                if (board[r][c] != '.') {
                    if (downhaveArray[board[r][c]-'1']) {
                        return false
                    } else {
                        downhaveArray[board[r][c]-'1'] = true
                    }
                }
                if (board[c][r] != '.') {
                    if (righthaveArray[board[c][r]-'1']) {
                        return false
                    } else {
                        righthaveArray[board[c][r]-'1'] = true
                    }
                }
            }
        }
        var dirBlock = arrayOf(Pair(-1, -1), Pair(-1, 0), Pair(-1, 1),
            Pair(0, -1), Pair(0, 0), Pair(0, 1),
            Pair(1, -1), Pair(1, 0), Pair(1, 1))
        var startPoint = arrayOf(Pair(1, 1), Pair(1, 4), Pair(1, 7),
            Pair(4, 1), Pair(4, 4), Pair(4, 7),
            Pair(7, 1), Pair(7, 4), Pair(7, 7))

        for (point in startPoint) {
            val haveArray = BooleanArray(10) { false }
            for (nextPoint in dirBlock) {
                val nx = point.first + nextPoint.first
                val ny = point.second + nextPoint.second
                if (board[nx][ny] != '.') {
                    if (haveArray[board[nx][ny]-'1']) {
                        return false
                    } else {
                        haveArray[board[nx][ny]-'1'] = true
                    }
                }
            }
        }
        return true
    }
}