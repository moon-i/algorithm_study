fun main() {
    val solution = RotatingTheBox()
    val params = arrayOf(charArrayOf('#','.','*','.'), charArrayOf('#','#','*','.'))
    solution.rotateTheBox(params)
}

class RotatingTheBox {
    fun rotateTheBox(box: Array<CharArray>): Array<CharArray> {
        var resultMap = Array<CharArray>(box[0].size) { y -> CharArray(box.size) { x -> box[box.size - 1 -x][y] } }
        var n = box.size
        var m = box[0].size

        for (j in n -1 downTo 0) {
            var count = 0
            for (i in 0 until m) {
                when(resultMap[i][j]) {
                    '.' -> {
                    }
                    '#' -> {
                        resultMap[i][j] = '.'
                        count++
                    }
                    '*' -> {
                        for (k in 1..count) {
                            resultMap[i - k][j] = '#'
                        }
                        count = 0
                    }
                }
            }
            for (k in 1 .. count) {
                resultMap[m - k][j] = '#'
            }
        }

        return resultMap
    }
}