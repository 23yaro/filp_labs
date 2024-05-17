class ListConvert {

    //Функция, которая для данного списка указывает, сколько элементов из
    //него могут быть квадратом какого-то из элементов списка.
    fun degreeOfNumberFromList(list: List<Int>): Int {
        val degreeList = list.map { it * it }.distinct()
        return list.count { degreeList.contains(it) }
    }

    //Вспомогательная функция, находит кол-во делителей
    fun countDivisors(n: Int): Int {
        return (1..n).count { n % it == 0 }
    }

    //Функция, которая по трем спискам составляет список, состоящий из
    //кортежей длины 3, где каждый кортеж (ai,bi,ci) с номером I получен следующим образом:
    //Ai – I по убыванию элемент первого списка
    //Bi – I по возрастанию суммы цифр элемент второго списка
    //Сi - I по убыванию количества делителей элемент третьего списка
    //Все элементы одного списка различны.
    //Если в списках B или C два элемента имеют одинаковый коэффициент, большим считается
    //элемент, больший по абсолютной величине.

    fun listsIt(listA: List<Int>, listB: List<Int>, listC: List<Int>): List<Triple<Int, Int, Int>> {
        return listA.indices.map { i ->
            Triple(listA.sortedDescending()[i], listB.sortedBy {
                it.toString().sumOf { it - '0' }
            }[i], listC.sortedByDescending { countDivisors(it) }[i])
        }
    }

    //Дан целочисленный массив и натуральный индекс (число, меньшее размера
    //массива). Необходимо определить является ли элемент по указанному индексу
    //глобальным минимумом.
    fun isGlobalMin(arr: IntArray, index: Int): Boolean {
        val minValue = arr.minOrNull() ?: return false
        return arr[index] == minValue
    }

    //Дан целочисленный массив. Необходимо найти индексы двух наименьших
    //элементов массива.
    fun findTwoMinIndices(arr: IntArray): Pair<Int, Int> {
        val smallestIndex = arr.indices.minByOrNull { arr[it] } ?: return Pair(-1, -1)
        val secondSmallestIndex = arr.indices.minByOrNull { if (it == smallestIndex) Int.MAX_VALUE else arr[it] } ?: return Pair(-1, -1)
        return Pair(smallestIndex, secondSmallestIndex)
    }

    //Дан целочисленный массив. Необходимо найти все пропущенные числа.
    fun findMissingNumbers(arr: IntArray): List<Int> {
        val fullRange = (arr.minOrNull() ?: 0)..(arr.maxOrNull() ?: 0)
        return fullRange.filterNot { arr.contains(it) }
    }

    //Дан целочисленный массив. Найти количество чётных элементов.
    fun countEvenNumbers(arr: IntArray): Int {
        return arr.count { it % 2 == 0 }
    }

    //Дан целочисленный массив и интервал a..b. Необходимо найти количество
    //элементов в этом интервале.
    fun countElementsInInterval(arr: IntArray, a: Int, b: Int): Int {
        return arr.count { it in a..b }
    }

    //Дан целочисленный массив. Необходимо найти элементы, расположенные
    //между первым и последним максимальным.
    fun findElementsBetweenMax(arr: IntArray): List<Int> {
        val maxIndexFirst = arr.max().let { arr.indexOf(it) }
        val maxIndexLast = arr.lastIndexOf(arr.max())

        if (maxIndexFirst == maxIndexLast) return emptyList()

        val startIndex = minOf(maxIndexFirst, maxIndexLast) + 1
        val endIndex = maxOf(maxIndexFirst, maxIndexLast) - 1

        return if (startIndex <= endIndex) arr.slice(startIndex..endIndex) else emptyList()
    }
}