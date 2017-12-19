package days.day11

object Part1 {

    fun solve(puzzleInput: List<String>): Int {

        val delta = puzzleInput
                .map(::directionToHexCoordinate)
                .reduce { acc, axialCoordinate ->
                    acc + axialCoordinate
                }

        return distance(AxialCoordinate(0, 0), delta)
    }
}
