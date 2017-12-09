package days.day6

object Part2 {

    fun solve(puzzleInput: List<Int>): Any {

        val iterations = mutableListOf(puzzleInput)

        val memoryBank = MemoryBank(puzzleInput)
        memoryBank.redistribute()

        while (memoryBank.currentState !in iterations) {
            iterations += memoryBank.currentState
            memoryBank.redistribute()
        }

        return iterations.size - iterations.indexOfFirst { it == memoryBank.currentState }
    }
}
