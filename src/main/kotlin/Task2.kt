package org.example

fun runTask2() {
    var count = 0
    var sum = 0.0

    println("Вводите числа по одному. Для завершения введите 0:")

    var number = readln().toDouble()

    while (number != 0.0) {
        count = count + 1
        sum = sum + number
        number = readln().toDouble()
    }

    println("Количество введённых чисел: $count")
    println("Сумма введённых чисел: $sum")

    if (count == 0) {
        println("Среднее арифметическое: нет введённых чисел")
    } else {
        println("Среднее арифметическое: ${sum / count}")
    }
}