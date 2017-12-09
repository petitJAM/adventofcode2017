package days.day7

object PuzzleInputParser {

    fun parse(puzzleInput: String): List<Program> {
        return puzzleInput
                .split("\n")
                .map { it.split(" -> ") }
                .map {
                    val firstHalf = it[0].split(" ")
                    val name = firstHalf[0]
                    val weight = if (firstHalf.size > 1) {
                        firstHalf[1].trim('(', ')').toInt()
                    } else {
                        0
                    }
                    val namesOfProgramsAbove = if (it.size > 1) {
                        it[1].split(", ")
                    } else {
                        emptyList()
                    }
                    Program(name, weight, namesOfProgramsAbove)
                }
    }
}