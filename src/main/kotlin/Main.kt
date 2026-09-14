package org.example

fun main() {
    println("Введите целое положительное число:")
    val input = readln()

    val firstDigit = input.first().digitToInt()
    val lastDigit = input.last().digitToInt()

    println("Первая цифра: $firstDigit")
    println("Последняя цифра: $lastDigit")
    println("Сумма первой и последней цифры: ${firstDigit + lastDigit}")
}