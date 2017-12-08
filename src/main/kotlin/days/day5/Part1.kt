package days.day5

object Part1 {

    fun solve(puzzleInput: List<Int>): Int {
        val program = puzzleInput.toMutableList()

        var currentIndex = 0
        var steps = 0

        while(currentIndex < program.size) {
            val currentInstruction = program[currentIndex]
            program[currentIndex] += 1
            currentIndex += currentInstruction
            steps += 1
        }
        return steps
    }
}