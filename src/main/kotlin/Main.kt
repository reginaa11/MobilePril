package org.example

fun main() {
    println("Введите номер задания (1–10):")
    val choice = readln().toInt()

    when (choice) {
        1 -> runTask1()
        else -> println("Задание пока не реализовано")
    }
}