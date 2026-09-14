package org.example

fun isPrime(number: Int): Boolean {
    if (number < 2) {
        return false
    }

    var divisor = 2
    while (divisor * divisor <= number) {
        if (number % divisor == 0) {
            return false
        }
        divisor = divisor + 1
    }

    return true
}

fun runTask4() {
    println("Введите количество простых чисел n:")
    val n = readln().toInt()

    var count = 0
    var candidate = 2

    while (count < n) {
        if (isPrime(candidate)) {
            count = count + 1
            println("$count-ое число: $candidate")
        }
        candidate = candidate + 1
    }
}