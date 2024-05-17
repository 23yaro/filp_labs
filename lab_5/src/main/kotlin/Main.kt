import java.io.File

fun main() = Main().functions("C:\\Users\\sanch\\OneDrive\\Рабочий стол\\asd\\src\\test\\test.txt")
class Main {

    //Функция находит сумму всех делителей числа, взаимно простых с суммой цифр числа и не
    //взаимно простых с произведением цифр числа.

    fun divisorsSum(number: Int): Int {
        var sum = 0
        for (i in 1..number) {
            if (number % i == 0 && isPrime(i, digitSum(number)) && !isPrime(i, digitMul(number))) {
                sum += i
            }
        }
        return sum
    }


    //Функция находит сумму чисел.
    fun digitSum(number: Int): Int {
        var sum = 0
        var num = number
        while (num != 0) {
            sum += num % 10
            num /= 10
        }
        return sum
    }

    //Функция находит произведение чисел.
    fun digitMul(number: Int): Int {
        var product = 1
        var num = number
        while (num != 0) {
            product *= num % 10
            num /= 10
        }
        return product
    }

    //Функция определяет простое число или нет
    fun isPrime(a: Int, b: Int): Boolean {
        return nod(a, b) == 1
    }

    //Функция находит количество делителей числа, не делящихся на 3
    fun divisors(number: Int): Int {
        var count = 0
        for (i in 1..number) {
            if (number % i == 0 && i % 3 != 0) {
                count++
            }
        }
        return count
    }

    //Читает данные из файла, выполняет соответствующие функции
    fun functions(route: String) {
        if (route.isEmpty()) {
            println("Необходимо передать путь к файлу в качестве аргумента программы")
            return
        }

        val inputFile = File(route)
        if (!inputFile.exists()) {
            println("Файл не найден")
            return
        }

        val outputLines = mutableListOf<String>()

        inputFile.forEachLine { line ->
            val parts = line.split(" ")
            if (parts.size > 3 || parts.size < 2) {
                outputLines.add("Ошибка: неверная структура файла - $line")
                return@forEachLine
            }

            val number1 = parts[0].toIntOrNull()
            if (number1 == null) {
                outputLines.add("Ошибка: неверная структура файла")
                return@forEachLine
            }
            val number2 = parts[1]
            val functionName = parts[1]

            val result = when (functionName) {
                "maxDigit" -> maxDigit(number1.toInt())
                "minDigit" -> minDigit(number1.toInt())
                "nod" -> nod(number1.toInt(), number2.toInt())
                "divisorsSum" -> divisorsSum(number1.toInt())
                else -> {
                    "Ошибка: неизвестная функция - $functionName"
                }
            }

            outputLines.add("$number1 $functionName $result")
        }
        if (outputLines.isEmpty()) {
            outputLines.add("Ошибка: неверная структура файла")
        }
        val outputFile = File("output.txt")
        outputFile.writeText(outputLines.joinToString("\n"))

        println("Результаты записаны в файл output.txt")
    }

    //Функции высшего порядка, принимает функцию и значение
    fun operation(n: Int, f: (Int) -> (Int)) = f(n)
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


    tailrec fun nod(a: Int, b: Int): Int {
        return if (b == 0) {
            a
        } else {
            nod(b, a % b)
        }
    }

    tailrec fun maxDigit(number: Int, maxD: Int = 0): Int {
        if (number == 0) {
            return maxD
        }

        val digit = number % 10
        val newMaxDigit = if (digit > maxD) digit else maxD
        return maxDigit(number / 10, newMaxDigit)
    }

    tailrec fun minDigit(number: Int, minD: Int = 0): Int {
        if (number == 10) {
            return minD
        }

        val digit = number % 10
        val newMinDigit = if (digit < minD) digit else minD
        return minDigit(number / 10, newMinDigit)
    }

}

