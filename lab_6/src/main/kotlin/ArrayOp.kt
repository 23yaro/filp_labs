class ArrayOp {
    tailrec fun arrayOp(list: List<Int>, i: Int, stack: Int = 0, f: (Int, Int) -> Int): Int {
        return if (i <= 0) stack else arrayOp(list, f(stack, list[i - 1]), i - 1, f)
    }

    fun sumD(list: List<Int>): Int = arrayOp(list, list.size, 0) { a, b -> (a + b) }
    fun mulD(list: List<Int>): Int = arrayOp(list, list.size, 0) { a, b -> (a * b) }
    fun maxD(list: List<Int>): Int = arrayOp(list, list.size, 0) { a, b -> if (a > b) a else b }
    fun minD(list: List<Int>): Int = arrayOp(list, list.size, 0) { a, b -> if (a < b) a else b }

    fun popular(list: List<Int>): Int {
        if (list.isEmpty()) return 0
        val map: MutableMap<Int, Int> = mutableMapOf()
        for (x in list) map[x] = map.getOrDefault(x, 0) + 1
        var digit = 1
        var count = map.values.first()
        for (x in map) {
            if (x.value > count) {
                digit = x.key
                count = x.value
            }
        }
        return digit
    }

    fun evenDigit(list: MutableList<Int>): List<Int> {
        if (list.isEmpty()) return list
        val result: MutableList<Int> = mutableListOf()
        val map: MutableMap<Int, Int> = mutableMapOf()
        for (x in list) map[x] = map.getOrDefault(x, 0) + 1
        for (x in map) if ((x.key % 2 == 0) and (x.value % 2 == 0)) result.add(x.key)
        return result
    }

    fun removeNig(list: MutableList<Int>): List<Int> {
        if (list.isEmpty()) return list
        val result:MutableList<Int> = mutableListOf()
        for (x in list) if (x < 0) {
            if(sumDigits(x)<10)
                result.add(x)
        }
        return result
    }

    fun sumDigits(digit: Int, sum: Int = 0): Int = if (digit == 0) sum else sumDigits(digit / 10, sum + digit % 10)
}