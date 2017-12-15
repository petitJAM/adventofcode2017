package days.day11

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day11 : Day {

    override fun run() {
        val rawInput = PuzzleInputReader("puzzleInputs/day11.txt").readFile().trim()
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        println("Part 1")
        println(Part1.solve(puzzleInput))

        println("Part 2")
        println(Part2.solve(puzzleInput))
    }
}
