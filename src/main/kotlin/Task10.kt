package org.example

open class Vehicle {
    open val name: String = "Транспорт"
    open val speed: Int = 0

    open fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }

    open fun stop() {
        println("$name остановился")
    }
}

class Boat : Vehicle() {
    override val name: String = "Лодка"
    override val speed: Int = 40

    override fun start() {
        println("$name начала движение по воде со скоростью $speed км/ч")
    }

    override fun stop() {
        println("$name остановилась у берега")
    }
}

class Airplane : Vehicle() {
    override val name: String = "Самолёт"
    override val speed: Int = 850

    override fun start() {
        println("$name начал полёт со скоростью $speed км/ч")
    }

    override fun stop() {
        println("$name завершил полёт")
    }
}

class Tank : Vehicle() {
    override val name: String = "Танк"
    override val speed: Int = 60

    override fun start() {
        println("$name начал движение со скоростью $speed км/ч")
    }

    override fun stop() {
        println("$name остановился")
    }
}

fun runTask10() {
    val vehicles = arrayOf(Boat(), Airplane(), Tank())

    for (vehicle in vehicles) {
        vehicle.start()
        vehicle.stop()
        println("---")
    }
}