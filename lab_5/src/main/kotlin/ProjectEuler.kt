fun main() {
    var totalSum = 0

    for (num in 2..999999) {
        if (num == getSumOfDigits(num, 0)) {
            totalSum += num
        }
    }

    println("Сумма всех чисел, которые можно записать как сумму пятых степеней их цифр: $totalSum")
}

fun getSumOfDigits(number: Int, sum: Int): Int {
    if (number == 0) {
        return sum
    } else {
        val digit = number % 10
        val newSum = sum + Math.pow(digit.toDouble(), 5.0).toInt()
        return getSumOfDigits(number / 10, newSum)
    }
}