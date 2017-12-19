package days.day12

object PuzzleInputParser {

    fun parse(puzzleInput: String): Map<Int, List<Int>> {
        return puzzleInput.split("\n")
                .map {
                    val halves = it.split(" <-> ")
                    halves[0].toInt() to halves[1].split(", ").map(String::toInt)
                }.toMap()
    }
}
