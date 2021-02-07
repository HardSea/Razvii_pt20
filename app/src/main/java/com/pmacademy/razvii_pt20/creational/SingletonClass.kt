package com.pmacademy.razvii_pt20.creational

class SingletonClass private constructor(value: String) {

    private var someData: String = value

    fun printData(){
        println(someData)
    }

    companion object {
        private var instance: SingletonClass? = null

        fun getInstance(value: String): SingletonClass {
            return instance ?: SingletonClass(value)
        }
    }
}

fun main() {
    val singleton = SingletonClass.getInstance("h1")
    singleton.printData()
}