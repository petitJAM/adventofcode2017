package days.day5

import days.Day

@Suppress("unused")
object Day5 : Day {

    override fun run() {
        val input = puzzleInput.split(" ").map { it.toInt() }

        println("Part 1")
        println(Part1.solve(input))

        println("Part 2")
        println(Part2.solve(input))
    }
}