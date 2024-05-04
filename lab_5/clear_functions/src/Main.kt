class Cycle {
    fun operation(n: Int, f: (Int)->(Int)) = f(n)
    fun nodOperation(a: Int, b: Int, f: (Int, Int) -> (Int)) = f(a, b)

    //Функция находит максимальную цифру числа.
    fun maxDigit(number: Int): Int {
        var maxDigit = 0
        var num = number

        while (num != 0) {
            val digit = num % 10
            if (digit > maxDigit) {
                maxDigit = digit
            }
            num /= 10
        }

        return maxDigit
    }

    //Функция находит минимальную нечетную цифру числа.
    fun minDigit(number: Int): Int {
        var minDigit = number
        var num = number

        while (num != 0) {
            val digit = num % 10
            if (digit % 2 != 0 && digit < minDigit) {
                minDigit = digit
            }
            num /= 10
        }

        return minDigit
    }

    //Функция находит НОД двух чисел.
    fun nod(a: Int, b: Int): Int {
        var num1 = a
        var num2 = b

        while (num2 != 0) {
            val temp = num2
            num2 = num1 % num2
            num1 = temp
        }

        return num1
    }
}

class RecUp {
    fun operation(n: Int, f: (Int) -> (Int)) = f(n)
    fun nodOperation(a: Int, b: Int, f: (Int, Int) -> (Int)) = f(a, b)

    fun nod(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else {
            nod(b, a % b)
        }
    }

    fun maxDigit(number: Int): Int {
        if (number < 10) {
            return number
        }

        val maxRest = maxDigit(number / 10)
        val lastDigit = number % 10

        return maxOf(maxRest, lastDigit)
    }

    fun minDigit(number: Int): Int {
        if (number < 10) {
            return number
        }

        val minRest = minDigit(number / 10)
        val lastDigit = number % 10

        return minOf(minRest, lastDigit)
    }

}

class RecDown {
    fun operation(n: Int, f: (Int) -> (Int)) = f(n)
    fun nodOperation(a: Int, b: Int, f: (Int, Int) -> (Int)) = f(a, b)


    fun nod(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else {
            nod(b, a % b)
        }
    }

    fun maxDigit(number: Int): Int {
        if (number < 10) {
            return number
        }

        val lastDigit = number % 10
        val remainingDigits = number / 10
        val maxInRemaining = maxDigit(remainingDigits)

        return if (lastDigit > maxInRemaining) lastDigit else maxInRemaining
    }

    fun minDigit(number: Int): Int {
        if (number < 10) {
            return number
        }

        val lastDigit = number % 10
        val remainingDigits = number / 10
        val minInRemaining = minDigit(remainingDigits)

        return if (lastDigit > minInRemaining) lastDigit else minInRemaining
    }

}

