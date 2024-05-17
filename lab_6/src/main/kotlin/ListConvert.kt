import kotlin.math.absoluteValue
import kotlin.math.sqrt

class ListConvert {

    //Задача 2

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

    //Задача 3

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
    fun findElementsBetween(arr: IntArray): List<Int> {
        val maxIndexFirst = arr.max().let { arr.indexOf(it) }
        val maxIndexLast = arr.lastIndexOf(arr.max())

        if (maxIndexFirst == maxIndexLast) return emptyList()

        val startIndex = minOf(maxIndexFirst, maxIndexLast) + 1
        val endIndex = maxOf(maxIndexFirst, maxIndexLast) - 1

        return if (startIndex <= endIndex) arr.slice(startIndex..endIndex) else emptyList()
    }

    //Задача 6

    //Найти среднее арифметическое модулей элементов целочисленного массива.
    fun findAverageOfModuleValues(array: IntArray): Double {
        return array.map { it.absoluteValue }.average()
    }

    //Найти сумму элементов, значение которых попадает в интервал a..b.
    fun sumOfElementsInRange(array: IntArray, a: Int, b: Int): Int {
        return array.filter { it in a..b }.sum()
    }

    //Построить новый список из элементов, встречающихся только в одном из двух списков и не повторяющихся.
    fun findUniqueElements(list1: List<Int>, list2: List<Int>): List<Int> {
        return (list1 + list2).groupingBy { it }.eachCount().filter { it.value == 1 }.keys.toList()
    }

    //Построить новый список из квадратов неотрицательных чисел, меньших 100 и встречающихся в массиве больше 2 раз.
    fun findSquaresOfRepeatedNumbers(list: List<Int>): List<Int> {
        return list.filter { it < 100 }.groupingBy { it }.eachCount().filter { it.value > 2 }.keys.map { it * it }
    }

    //Задача 7
    //Для введенного списка построить новый список, который получен из начального
    //упорядочиванием по параметру P(a), где
    //P(a) – сумма делителей числа а, которые являются делителями хотя бы одного из
    //элементов списка, стоящих на четных позициях и не являются делителями ни одного из
    //элементов, которые меньше среднего арифметического данного списка.

    private fun sumOfDivisors(number: Int): Int {
        var sum = 1
        for (i in 2..(number / 2)) {
            if (number % i == 0) {
                sum += i
            }
        }
        return sum
    }

    fun listOfSumDigit(inputList: List<Int>): List<Int> {
        val evenPositions = inputList.filterIndexed { index, _ -> index % 2 == 0 }
        val average = inputList.average()

        return inputList.sortedBy { a ->
            val divisorsSum = sumOfDivisors(a)
            val divisorsSet = evenPositions.flatMap { number -> if (number != a) setOf(sumOfDivisors(number)) else emptySet() }.toSet()
            if (divisorsSet.any { it == divisorsSum } && divisorsSet.none { it == sumOfDivisors(average.toInt()) }) divisorsSum else Int.MAX_VALUE
        }
    }

    //Для введенного списка построить новый список, в который войдут лишь те элементы, которые
    //- больше, чем сумма всех предыдущих в исходном списке,
    //- являются полным квадратом одного из элементов исходного списка,
    //- делятся на все предыдущие элементы исходного списка.
    //В итоговый список включить кортеж (число, сумма предыдущих, количество элементов в списке больше заданного).
    fun eList(inputList: List<Int>): List<Triple<Int, Int, Int>> {
        val sumOfPrevious = inputList.runningReduce { acc, i -> acc + i }
        val isSquare = { num: Int -> sqrt(num.toDouble()) % 1 == 0.0 }

        return inputList.mapIndexed { index, currentNumber ->
            val previousNumbers = inputList.subList(0, index)
            val meetsConditions = currentNumber > (sumOfPrevious.getOrNull(index - 1) ?: 0) &&
                    previousNumbers.all { currentNumber % it == 0 } &&
                    previousNumbers.any { isSquare(currentNumber / it) }

            if (meetsConditions) {
                val countGreaterThanCurrent = inputList.count { it > currentNumber }
                Triple(currentNumber, sumOfPrevious.getOrNull(index - 1) ?: 0, countGreaterThanCurrent)
            } else null
        }.filterNotNull()
    }

    //Даны две последовательности, найти наибольшую по длине общую
    //подпоследовательность.
    fun findLongestSub(seq1: String, seq2: String): String {
        if (seq1.isEmpty() || seq2.isEmpty()) {
            return ""
        }

        val lastCharSeq1 = seq1.last()
        val lastCharSeq2 = seq2.last()

        if (lastCharSeq1 == lastCharSeq2) {
            val subsequence = findLongestSub(seq1.dropLast(1), seq2.dropLast(1))
            return subsequence + lastCharSeq1
        } else {
            val subsequence1 = findLongestSub(seq1, seq2.dropLast(1))
            val subsequence2 = findLongestSub(seq1.dropLast(1), seq2)
            return if (subsequence1.length > subsequence2.length) subsequence1 else subsequence2
        }
    }
}