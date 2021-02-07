package com.pmacademy.razvii_pt20.creational


fun main() {
    val mainScreen = MainScreen()
    val button = mainScreen.getCurrentButton(MobileFactory())
    button.draw(x = 10, y = 15)
    println(button.getType())
}

class MainScreen {
    private var currentButton: Button? = null

    fun getCurrentButton(buttonFactory: ButtonFactory): Button {
        return currentButton ?: buttonFactory.createButton().also {
            currentButton = it
        }
    }
}


interface Button {
    fun draw(x: Int, y: Int)
    fun getType(): String
}

class MobileButton : Button {
    override fun draw(x: Int, y: Int) {
        println("I draw mobile button on this position: x - $x, y - $y")
    }

    override fun getType() = "mobile"
}

class LaptopButton : Button {
    override fun draw(x: Int, y: Int) {
        println("I draw laptop button on this position: x - $x, y - $y")
    }

    override fun getType(): String = "laptop"
}

interface ButtonFactory {
    fun createButton(): Button
}

class MobileFactory : ButtonFactory {
    override fun createButton(): Button {
        return MobileButton()
    }
}

class LaptopFactory : ButtonFactory {
    override fun createButton(): Button {
        return LaptopButton()
    }

}

