package days.day10

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day10 : Day {

    override fun run() {
        val rawInput = PuzzleInputReader("puzzleInputs/day10.txt").readFile()
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        println("Part 1")
        println(Part1.solve(puzzleInput, 256))

        println("Part 2")
        println(Part2.solve(puzzleInput))
    }
}
