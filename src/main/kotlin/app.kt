@file:JvmName("Main")

import days.day1.Day1
import days.day2.Day2
import days.day3.Day3
import days.day4.Day4
import days.day5.Day5
import days.day6.Day6

fun main(args: Array<String>) {
    println("Advent of Code 2017")
//    io()
    Day6.run()
}

fun io() {
    println("Enter a day number: ")
    while (true) {
        when(readLine()) {
            "q" -> System.exit(0)
            "1" -> Day1.run()
            "2" -> Day2.run()
            "3" -> Day3.run()
            "4" -> Day4.run()
            "5" -> Day5.run()
            "6" -> Day6.run()
            else -> println("What?")
        }
        println()
    }
}