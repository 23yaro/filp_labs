fun main() = Main().main()

class Main {
    fun main() {
        println(nod(12,6))
    }

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
        var minDigit = 0
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