package days.day4

object Day4 {

    fun run() {
        val splitInput = puzzleInput.split("\n")

        println("Part 1")
        println(Part1.solve(splitInput))

        println("Part 2")
        println(Part2.solve(splitInput))
    }
}