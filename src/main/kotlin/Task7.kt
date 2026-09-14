package org.example

import kotlin.math.sqrt

fun sqr(number: Double): Double {
    return number * number
}

fun discriminant(a: Double, b: Double, c: Double): Double {
    return sqr(b) - 4 * a * c
}

fun rootsNumber(a: Double, b: Double, c: Double): Int {
    val d = discriminant(a, b, c)
    return when {
        d > 0 -> 2
        d == 0.0 -> 1
        else -> 0
    }
}

fun quadraticRoot(a: Double, b: Double, c: Double) {
    val d = discriminant(a, b, c)
    val count = rootsNumber(a, b, c)

    when (count) {
        2 -> {
            val x1 = (-b + sqrt(d)) / (2 * a)
            val x2 = (-b - sqrt(d)) / (2 * a)
            println("Корни: x1 = $x1, x2 = $x2")
        }
        1 -> {
            val x = -b / (2 * a)
            println("Корень: x = $x")
        }
        else -> println("Действительных корней нет")
    }
}

fun runTask7() {
    println("Введите коэффициенты a, b, c:")
    val a = readln().toDouble()
    val b = readln().toDouble()
    val c = readln().toDouble()

    println("Квадрат b: ${sqr(b)}")
    println("Дискриминант: ${discriminant(a, b, c)}")
    println("Количество корней: ${rootsNumber(a, b, c)}")
    quadraticRoot(a, b, c)
}