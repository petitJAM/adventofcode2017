package days.day4

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day4 : Day {

    override fun run() {
        val puzzleInput = PuzzleInputReader("puzzleInputs/day4.txt").readFile()
        val splitInput = puzzleInput.split("\n")

        println("Part 1")
        println(Part1.solve(splitInput))

        println("Part 2")
        println(Part2.solve(splitInput))
    }
}