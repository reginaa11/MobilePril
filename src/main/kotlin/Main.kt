package org.example

fun main() {
    println("Введите номер задания (1–10):")
    val choice = readln().toInt()

    when (choice) {
        1 -> runTask1()
        2 -> runTask2()
        3 -> runTask3()
        4 -> runTask4()
        5 -> runTask5()
        6 -> runTask6()
        7 -> runTask7()
        else -> println("Задание пока не реализовано")
    }
}