import java.util.*
import kotlin.collections.ArrayList

fun main() {
    val solution = GenerateParentheses()
    solution.generateParenthesis(3).map {
        println(it)
    }
}

class GenerateParentheses {
    lateinit var list: ArrayList<String>
    fun generateParenthesis(n: Int): List<String> {
        list = ArrayList()

        dfs(n, n, "")

        return list.toList()
    }

    fun dfs(sChar: Int, eChar: Int, currentString: String) {
        if (sChar == 0 && eChar == 0) {
            if (check(currentString)) {
                list.add(currentString)
            }
            return
        }

        if (sChar > 0) {
            dfs(sChar-1, eChar, "$currentString(")
        }
        if (eChar > 0) {
            dfs(sChar, eChar-1, "$currentString)")
        }
    }

    fun check(str: String): Boolean {
        var stack: Stack<String> = Stack()
        (str.indices).map {
            when (str[it].toString()) {
                "(" -> {
                    stack.add("(")
                }
                else -> {
                    if (!stack.empty()) {
                        val temp = stack.pop()
                        if (temp != "(") {
                            return false
                        } else { /* keep going */}
                    } else return false
                }
            }
        }
        return true
    }
}