package days.day6

object Day6 {

    fun run() {
        val input = puzzleInput.split("\t").map(String::toInt)

        println("Part 1")
        println(Part1.solve(input))

        println("Part 2")
        println(Part2.solve(input))
    }
}
