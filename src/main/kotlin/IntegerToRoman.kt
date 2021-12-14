fun main() {
    val solution = IntegerToRoman()
    println(solution.intToRoman(1994))
}

class IntegerToRoman {
    fun intToRoman(num: Int): String {
        var result = ""

        // 1000
        (num / 1000).let { v ->
            for(i in 0 until v) {
                result = "${result}M"
            }
        }

        // 100
        ((num % 1000) / 100).let { v ->
            result = if (v == 4) {
                "${result}CD"
            } else if (v == 9) {
                "${result}CM"
            } else {
                var tempV = v
                if (tempV >= 5) {
                    result = "${result}D"
                    tempV -= 5
                }
                for(i in 0 until tempV) {
                    result = "${result}C"
                }
                result
            }
        }

        // 1
        ((num % 100) / 10).let { v ->
            result = if (v == 4) {
                "${result}XL"
            } else if (v == 9) {
                "${result}XC"
            } else {
                var tempV = v
                if (tempV >= 5) {
                    result = "${result}L"
                    tempV -= 5
                }
                for(i in 0 until tempV) {
                    result = "${result}X"
                }
                result
            }
        }

        // 1
        (num % 10).let { v ->
            result = if (v == 4) {
                "${result}IV"
            } else if (v == 9) { 
                "${result}IX"
            } else {
                var tempV = v
                if (tempV >= 5) {
                    result = "${result}V"
                    tempV -= 5
                }
                for(i in 0 until tempV) {
                    result = "${result}I"
                }
                result
            }
        }

        return result
    }
}