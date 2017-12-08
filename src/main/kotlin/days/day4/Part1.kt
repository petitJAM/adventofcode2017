package days.day4

object Part1 {

    fun solve(puzzleInput: List<String>): Int {
        return puzzleInput.filter { passPhrase: String ->
            val words = passPhrase.split(" ")
            words.size == words.distinct().size
        }.count()
    }
}