package org.example

fun runTask5() {
    val numbers = intArrayOf(1, 5, 2, 8, 3, 7, 4)

    println("Исходный массив: ${numbers.joinToString()}")

    print("Элементы больше соседей: ")
    for (index in 1 until numbers.lastIndex) {
        if (numbers[index] > numbers[index - 1] && numbers[index] > numbers[index + 1]) {
            print("${numbers[index]} ")
        }
    }
    println()
}