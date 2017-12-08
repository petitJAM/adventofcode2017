package days.day5

object Day5 {

    fun run() {
        val input = puzzleInput.split(" ").map { it.toInt() }

        println("Part 1")
        println(Part1.solve(input))

        println("Part 2")
        println(Part2.solve(input))
    }
}