package days.day4

import util.PuzzleInputReader

object Day4 {

    fun run() {
        val puzzleInput = PuzzleInputReader("puzzleInputs/day4.txt").readFile()
        val splitInput = puzzleInput.split("\n")

        println("Part 1")
        println(Part1.solve(splitInput))

        println("Part 2")
        println(Part2.solve(splitInput))
    }
}