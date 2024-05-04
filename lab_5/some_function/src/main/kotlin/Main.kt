fun main() {

}

//Функция находящая максимальное из чисел [X,Y,Z]
fun max(X: Int, Y: Int, Z: Int): Int {
    return if (X > Y && X > Z) X else if (Y > Z) Y else Z
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
fun sumOfNumbersU(N: Int):Int{
    return if(N==0) 0 else N%10 + sumOfNumbersU(N/10)
}

//Функция для нахождения суммы цифр числа с помощью рекурсии вверх.
fun sumOfNumbersD(N: Int, res:Int = 0):Int{
    return if(N==0) res else sumOfNumbersD(N/10,res+N%10)
}

//Функция возвращающая функцию суммы цифр числа, если ее аргумент true, иначе функцию факториала числа
fun sumOrFactorNumber(condition:Boolean): (Int)->Int {
    return if(condition) ::sumOfNumbersD else ::factD
}