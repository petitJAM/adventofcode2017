package days.day5

object Part2 {

    fun solve(puzzleInput: List<Int>): Int {
        val program = puzzleInput.toMutableList()

        var currentIndex = 0
        var steps = 0

        while(currentIndex < program.size) {
            val currentInstruction = program[currentIndex]
            program[currentIndex] += if (currentInstruction >= 3) -1 else 1
            currentIndex += currentInstruction
            steps += 1
        }
        return steps
    }
}