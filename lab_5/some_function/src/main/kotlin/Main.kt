fun main() = Main().main()

class Main
{
    fun main(){};

    //Функция находящая максимальное из чисел [x,y,z]
    fun max(x: Int, y: Int, z: Int): Int {
        return if (x > y && x > z) x else if (y > z) y else z
    }

    //Фукция факторила реализованная с помощью рекурсии вверх
    fun factU(N: Int): Int {
        return if (N == 0) 1 else N * factU(N - 1)
    }

    //Фукция факторила реализованная с помощью рекурсии вниз
    fun factD(N: Int, res: Int = 1): Int {
        return if (N == 0) res else factD(N - 1, res * N)
    }

    //Функция для нахождения суммы цифр числа с помощью рекурсии вверх.
    fun sumOfNumbersU(N: Int): Int {
        return if (N == 0) 0 else N % 10 + sumOfNumbersU(N / 10)
    }

    //Функция для нахождения суммы цифр числа с помощью рекурсии вверх.
    fun sumOfNumbersD(N: Int, res: Int = 0): Int {
        return if (N == 0) res else sumOfNumbersD(N / 10, res + N % 10)
    }

    //Функция возвращающая функцию суммы цифр числа, если ее аргумент true, иначе функцию факториала числа
    fun sumOrFactorNumber(condition: Boolean): (Int) -> Int {
        return if (condition) ::sumOfNumbersD else ::factD
    }

    //Функция обхода числа
    fun roundNumber(n: Int, initial: Int = 0, function: (Int, Int) -> Int): Int {
        return if (n == 0) initial else roundNumber(n / 10, function(initial, n % 10), function)
    }

    //вызовы через лямбды
    fun sumd(n: Int): Int = roundNumber(n, 0) { a, b -> (a + b) }
    fun muld(n: Int): Int = roundNumber(n, 1) { a, b -> (a * b) }
    fun maxd(n: Int): Int = roundNumber(n / 10, n % 10) { a, b -> if (a > b) a else b }
    fun mind(n: Int): Int = roundNumber(n / 10, n % 10) { a, b -> if (a < b) a else b }

}