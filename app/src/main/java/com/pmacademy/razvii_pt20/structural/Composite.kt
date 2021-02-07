package com.pmacademy.razvii_pt20.structural

fun main() {
    val nurse1 = Nurse(name = "Svetlana", age = 28)
    val nurse2 = Nurse(name = "Maria", age = 31)

    val hospitalDirectoryNurse = HospitalDirectory()

    hospitalDirectoryNurse.addEmployee(employee = nurse1)
    hospitalDirectoryNurse.addEmployee(employee = nurse2)

    val doctor1 = Doctor(name = "Ivan", age = 42)
    val doctor2 = Doctor(name = "Oleksandr", age = 40)

    val hospitalDirectoryDoctor = HospitalDirectory()

    hospitalDirectoryDoctor.addEmployee(employee = doctor1)
    hospitalDirectoryDoctor.addEmployee(employee = doctor2)

    val directory = HospitalDirectory()
    directory.addEmployee(employee = hospitalDirectoryNurse)
    directory.addEmployee(employee = hospitalDirectoryDoctor)
    directory.printEmployeeDetails()

}

interface Employee {
    fun printEmployeeDetails()
}

class Nurse(private var name: String, private var age: Int) : Employee {

    override fun printEmployeeDetails() {
        println("Nurse. Name: $name. Age: $age")
    }
}

class Doctor(private var name: String, private var age: Int) : Employee {

    override fun printEmployeeDetails() {
        println("Doctor. Name: $name. Age: $age")
    }
}

class HospitalDirectory : Employee {
    private var employeeList: ArrayList<Employee> = arrayListOf()


    fun addEmployee(employee: Employee) {
        employeeList.add(employee)
    }

    override fun printEmployeeDetails() {
        employeeList.forEach { it.printEmployeeDetails() }
    }

}