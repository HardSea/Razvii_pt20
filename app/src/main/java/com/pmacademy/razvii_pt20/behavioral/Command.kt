package com.pmacademy.razvii_pt20.behavioral


fun main() {
    val file = File(name = "Example", generation = 4)
    val openOperation = OpenOperation(file)

    val file2 = File(name = "Example2", generation = 5)
    val closeOperation1 = CloseOperation(file2)

    val file3 = File(name = "Example3", generation = 6)
    val openOperation2 = OpenOperation(file3)

    val operationHistory = OperationHistory()
    operationHistory.takeOperation(openOperation)
    operationHistory.takeOperation(closeOperation1)
    operationHistory.takeOperation(openOperation2)
    operationHistory.placeOperation()


}

interface Operation {
    fun execute()
}

class CloseOperation(private val file: File) : Operation {

    override fun execute() {
        file.close()
    }
}

class OpenOperation(private val file: File) : Operation {

    override fun execute() {
        file.open()
    }

}

class File(private val name: String, private val generation: Int) {
    fun open() {
        println("Open operation run. File name - $name. His generation - $generation")
    }

    fun close() {
        println("Close operation run. File name - $name. His generation - $generation")
    }
}

class OperationHistory {
    private val operationList: ArrayList<Operation> = arrayListOf()

    fun takeOperation(operation: Operation) {
        operationList.add(operation)
    }

    fun placeOperation() {
        operationList.forEach { it.execute() }
        operationList.clear()
    }
}

