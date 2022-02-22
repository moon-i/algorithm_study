fun main() {
    val solution  = ExcelSheetColumnNumber()
    println(solution.titleToNumber("ZY"))
}
class ExcelSheetColumnNumber {
    fun titleToNumber(columnTitle: String): Int {
        var temp = 1
        var result = 0
        for (i in columnTitle.length -1 downTo 0 ) {
            result += temp * (columnTitle[i] - 'A' + 1)
            temp *= 26
        }

        return result
    }
}