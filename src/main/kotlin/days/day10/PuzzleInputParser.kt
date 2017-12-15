package days.day10

object PuzzleInputParser {

    fun parse(puzzleInput: String): List<Int> {
        return puzzleInput.trim().split(",").map { it.toInt() }
    }
}