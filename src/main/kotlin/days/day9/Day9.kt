package days.day9

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day9 : Day {

    override fun run() {
        val stream = PuzzleInputReader("puzzleInputs/day9.txt").readFile()

        println("Part 1")
        println(Part1.solve(stream))

        println("Part 2")
        println(Part2.solve(stream))
    }
}
