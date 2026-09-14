package org.example

fun runTask3() {
    val hiddenNumber = (0..10).random()

    println("Угадайте число от 0 до 10:")

    while (true) {
        val guess = readln().toInt()

        if (guess > hiddenNumber) {
            println("Много")
        } else if (guess < hiddenNumber) {
            println("Мало")
        } else {
            println("Угадал")
            break
        }
    }
}
