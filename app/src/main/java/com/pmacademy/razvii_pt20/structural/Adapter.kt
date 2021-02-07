package com.pmacademy.razvii_pt20.structural

interface Car {
    fun getMaxSpeed(): Int
}

class Ferrari : Car {
    private val maxSpeed = 251
    override fun getMaxSpeed(): Int = maxSpeed
}

class Niva : Car {
    private val maxSpeed = 112
    override fun getMaxSpeed(): Int = maxSpeed
}

interface CarAdapter {
    // return speed in miles
    fun getMaxSpeed(): Int
}

class CarAdapterMph(private var car: Car) : CarAdapter {
    override fun getMaxSpeed(): Int {
        return convertKmToMiles(km = this.car.getMaxSpeed()).toInt()
    }

    private fun convertKmToMiles(km: Int): Double {
        return km * 0.621371
    }
}

class CarAdapterSteps(private var car: Car) : CarAdapter {
    override fun getMaxSpeed(): Int {
        return convertKmToSteps(km = this.car.getMaxSpeed())
    }

    private fun convertKmToSteps(km: Int): Int {
        return km * 1312
    }
}

fun main() {
    val niva: Car = Niva()
    val adapterSteps: CarAdapter = CarAdapterSteps(niva)
    val maxStepsSpeed = adapterSteps.getMaxSpeed()
    println("In cars world niva car has max speed in steps - $maxStepsSpeed")

    val ferrari: Car = Ferrari()
    val adapterMph: CarAdapter = CarAdapterMph(ferrari)
    val maxStepsMph = adapterMph.getMaxSpeed()
    println("In cars world niva car has max speed in steps - $maxStepsMph")

}