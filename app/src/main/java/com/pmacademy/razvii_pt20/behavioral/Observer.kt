package com.pmacademy.razvii_pt20.behavioral

fun main() {
    val subject = Subject()

    FloatObserver(subject)
    DoubleObserver(subject)

    println("New state - 474")
    subject.setState(newState = 474)

}

interface Observer {
    val subject: Subject
    fun update()
}


class Subject {
    private val observers: ArrayList<Observer> = arrayListOf()
    private var state: Int = 0

    fun setState(newState: Int) {
        state = newState
        notifyAllObservers()
    }

    fun getState(): Int = state

    fun attach(observer: Observer) {
        observers.add(observer)
    }

    private fun notifyAllObservers() {
        observers.forEach { it.update() }
    }
}

class FloatObserver(override val subject: Subject) : Observer {

    init {
        subject.attach(observer = this)
    }

    override fun update() {
        println("Float observer: ${subject.getState().toFloat()}")
    }

}

class DoubleObserver(override val subject: Subject) : Observer {

    init {
        subject.attach(observer = this)
    }

    override fun update() {
        println("Float observer: ${subject.getState().toDouble()}")
    }

}