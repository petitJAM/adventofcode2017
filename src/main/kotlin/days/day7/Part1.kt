package days.day7

object Part1 {

    fun solve(puzzleInput: List<Program>): String {
        return findBottomProgram(puzzleInput)?.name ?: "No Bottom Program"
    }
}
