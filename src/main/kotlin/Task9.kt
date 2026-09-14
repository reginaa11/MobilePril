package org.example

import kotlin.math.sqrt

class Vector(val x: Double, val y: Double, val z: Double) {

    fun length(): Double {
        return sqrt(x * x + y * y + z * z)
    }

    fun scalar(other: Vector): Double {
        return x * other.x + y * other.y + z * other.z
    }

    infix fun dot(other: Vector): Double {
        return scalar(other)
    }

    operator fun times(other: Vector): Double {
        return scalar(other)
    }
}

fun scalarProduct(v1: Vector, v2: Vector): Double {
    return v1.x * v2.x + v1.y * v2.y + v1.z * v2.z
}

fun runTask9() {
    val v1 = Vector(1.0, 2.0, 3.0)
    val v2 = Vector(3.0, 2.0, 1.0)

    println("Длина v1: ${v1.length()}")
    println("Длина v2: ${v2.length()}")
    println("Обычный метод: ${v1.scalar(v2)}")
    println("Infix-вызов: ${v1 dot v2}")
    println("Оператор *: ${v1 * v2}")
    println("Внешняя функция: ${scalarProduct(v1, v2)}")
}