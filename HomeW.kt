package com.example.homework

fun main() {
    try {
        println("Enter number 1:")
        val a: Int? = readLine()?.toInt()
        val num1 = a ?: return

        println("Enter operation is: +, -, *, /")
        val o = readLine()
        val operation = o ?: return

        println("Enter number 2:")
        val b = readLine()?.toInt()
        val num2 = b ?: return

        when (operation) {
            "+" -> println(num1 + num2)

            "-" -> println(num1 - num2)

            "*" -> println(num1 * num2)

            "/" -> println(num1 / num2)
            else -> println("the wrong character is entered ")

        }
    } catch (e: NumberFormatException) {
        println("Nothing is entered!")
    }
}