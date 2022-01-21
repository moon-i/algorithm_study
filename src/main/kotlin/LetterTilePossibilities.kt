
fun main() {
    val solution = LetterTilePossibilities()
    print(solution.numTilePossibilities("AAB"))
}

class LetterTilePossibilities {
    lateinit var visite: MutableList<Boolean>
    var _tiles = ""
    var result: MutableSet<String> = mutableSetOf()
    var tempList: MutableList<Char> = mutableListOf()
    fun numTilePossibilities(tiles: String): Int {
        _tiles = tiles
        visite = MutableList(tiles.length) { false }

        dfs()

        return result.size - 1
    }

    fun dfs() {
        result.add(tempList.toString())

        for (i in 0 until  _tiles.length) {
            if (!visite[i]) {
                visite[i] = true
                tempList.add(_tiles[i])
                dfs()
                tempList.removeAt(tempList.size - 1)
                visite[i] = false
            }
        }
    }
}