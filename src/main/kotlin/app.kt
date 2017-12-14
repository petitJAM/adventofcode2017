@file:JvmName("Main")

import days.Day

fun main(args: Array<String>) {
    println("Advent of Code 2017")
    io()
}

private val days: List<String> = (1..25).map { it.toString() }

fun io() {
    println("Enter a day number or 'q' to quit: ")
    while (true) {
        try {
            val input = readLine() ?: ""
            when(input) {
                "q" -> {
                    println("Goodbye! ^_^")
                    System.exit(0)
                }
                in days -> run(input)
                else -> println("That's not a valid day! >.>")
            }
        } catch (ex: Error) {
            println("Whoops! That one is broken :(")
        }
        println()
    }
}

private fun run(dayNumber: String) {
    try {
        val kClass = Class.forName("days.day$dayNumber.Day$dayNumber").kotlin
        val day = kClass.objectInstance as Day
        day.run()
    } catch (ex: ClassNotFoundException) {
        println("That day doesn't exist yet! :(")
    }
}