package days.day8

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day8 : Day {

    override fun run() {
        val rawInput = PuzzleInputReader("puzzleInputs/day8.txt").readFile()
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        println("Part 1")
        println(Part1.solve(puzzleInput))

        println("Part 2")
        println(Part2.solve(puzzleInput))
    }
}
