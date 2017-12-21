package days.day13

object PuzzleInputParser {

    fun parse(puzzleInput: String): Map<Int, Int> {
        return puzzleInput.split("\n").map { row ->
            val halves = row.split(": ").map(String::toInt)
            halves[0] to halves[1]
        }.toMap()
    }
}
