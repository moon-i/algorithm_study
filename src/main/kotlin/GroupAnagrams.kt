fun main() {
    val solution  = GroupAnagrams()
    solution.groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")).map { list ->
        list.map {
            print(it)
        }
        println()
    }
}

class GroupAnagrams {
    val hm: HashMap<List<Int>, MutableList<Int>> = HashMap()
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val result = ArrayList<List<String>>()
        strs.mapIndexed { index, s ->
            val list = MutableList<Int>(27) {0}
            for (i in 0 until s.length) {
                list[s[i]-'a']++
            }
            var value = hm.get(list.toList())
            if (value != null) {
                value.add(index)
            } else {
                value = MutableList(1) { index }
            }
            hm.put(list, value)
        }

        for (k in hm.keys) {
            val tempList = ArrayList<String>()
            hm[k]?.map { i ->
                tempList.add(strs[i])
            }
            result.add(tempList)
        }
        return result.toList()
    }
}