import days.Day1
import days.Day2

fun main(args: Array<String>) {
    println("Advent of Code 2017")
    io()
}

fun io() {
    println("Enter a day number: ")
    while (true) {
        when(readLine()) {
            "q" -> System.exit(0)
            "1" -> Day1.run()
            "2" -> Day2.run()
            else -> println("What?")
        }
        println()
    }
}