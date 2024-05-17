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




}