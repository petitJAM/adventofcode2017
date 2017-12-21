package days.day14

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day14 : Day {

    override fun run() {
        val rawInput = PuzzleInputReader("puzzleInputs/day14.txt").readFile()
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        println("Part 1")
        println(Part1.solve(puzzleInput))

        println("Part 2")
        println(Part2.solve(puzzleInput))
    }
}
