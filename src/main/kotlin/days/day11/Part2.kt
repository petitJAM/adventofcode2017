package days.day11

object Part2 {

    fun solve(puzzleInput: List<String>): Int {
        return puzzleInput
                .map(::directionToHexCoordinate)
                .fold(ReduceContainer(0, AxialCoordinate(0,0))) { acc, axialCoordinate ->
                    val newCoordinate = acc.currentCoordinate + axialCoordinate
                    val newDistance = distance(AxialCoordinate.ORIGIN, newCoordinate)
                    ReduceContainer(Math.max(acc.maxDistance, newDistance), newCoordinate)
                }
                .maxDistance
    }

    private data class ReduceContainer(val maxDistance: Int,
                                       val currentCoordinate: AxialCoordinate)
}
