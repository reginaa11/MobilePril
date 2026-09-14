package org.example

fun runTask6() {
    val numbers = intArrayOf(2, 5, 1, 8, 3)

    println("Массив: ${numbers.joinToString()}")

    // Через for
    var productFor = 1
    var minFor = numbers[0]
    var maxFor = numbers[0]
    for (number in numbers) {
        productFor = productFor * number
        if (number < minFor) minFor = number
        if (number > maxFor) maxFor = number
    }
    println("for: произведение = $productFor, min = $minFor, max = $maxFor")

    // Через while
    var productWhile = 1
    var minWhile = numbers[0]
    var maxWhile = numbers[0]
    var index = 0
    while (index < numbers.size) {
        val number = numbers[index]
        productWhile = productWhile * number
        if (number < minWhile) minWhile = number
        if (number > maxWhile) maxWhile = number
        index = index + 1
    }
    println("while: произведение = $productWhile, min = $minWhile, max = $maxWhile")

    // Через forEach
    var productForEach = 1
    var minForEach = numbers[0]
    var maxForEach = numbers[0]
    numbers.forEach { number ->
        productForEach = productForEach * number
        if (number < minForEach) minForEach = number
        if (number > maxForEach) maxForEach = number
    }
    println("forEach: произведение = $productForEach, min = $minForEach, max = $maxForEach")

    // Через reduce и встроенные функции
    val productReduce = numbers.reduce { product, number -> product * number }
    println("reduce: произведение = $productReduce")
    println("min() = ${numbers.min()}, max() = ${numbers.max()}")
}