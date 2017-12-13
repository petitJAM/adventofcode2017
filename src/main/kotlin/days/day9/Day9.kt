package days.day9

import util.PuzzleInputReader

object Day9 {

    fun run() {
        val stream = PuzzleInputReader("puzzleInputs/day9.txt").readFile()

        println("Part 1")
        println(Part1.solve(stream))

        println("Part 2")
        println(Part2.solve(stream))
    }
}
