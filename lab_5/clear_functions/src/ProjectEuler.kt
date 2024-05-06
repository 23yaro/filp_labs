fun main() {
    var totalSum = 0

    for (num in 2..999999) {
        if (num == getSumOfDigits(num, 0)) {
            totalSum += num
        }
    }

    println("Сумма всех чисел, которые можно записать как сумму пятых степеней их цифр: $totalSum")
}

fun getSumOfDigits(number: Int, sumSoFar: Int): Int {
    if (number == 0) {
        return sumSoFar
    } else {
        val digit = number % 10
        val newSum = sumSoFar + Math.pow(digit.toDouble(), 5.0).toInt()
        return getSumOfDigits(number / 10, newSum)
    }
}