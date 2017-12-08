package days.day4

object Part2 {

    fun solve(puzzleInput: List<String>): Int {
        return puzzleInput.filter { passPhrase: String ->
            val sortedLetters = passPhrase
                    .split(" ")
                    .map { word ->
                        word.split("").sorted().joinToString("")
                    }
            sortedLetters.size == sortedLetters.distinct().size
        }.count()
    }
}