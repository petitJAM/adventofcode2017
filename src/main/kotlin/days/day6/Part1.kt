package days.day6

object Part1 {

    fun solve(puzzleInput: List<Int>): Int {

        val iterations = mutableListOf(puzzleInput)

        val memoryBank = MemoryBank(puzzleInput)
        memoryBank.redistribute()

        while (memoryBank.currentState !in iterations) {
            iterations += memoryBank.currentState
            memoryBank.redistribute()
        }

        return iterations.size
    }
}
