package days.day12

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day12 : Day {

    override fun run() {
        val rawInput = PuzzleInputReader("puzzleInputs/day12.txt").readFile()
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        println("Part 1")
        println(Part1.solve(puzzleInput))

        println("Part 2")
        println(Part2.solve(puzzleInput))
    }
}
