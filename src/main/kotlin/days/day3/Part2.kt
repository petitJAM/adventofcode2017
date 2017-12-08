package days.day3

object Part2 {

    fun solve(puzzleInput: Int): Int {

        val spiralMemory = SpiralMemory<Int>()

        spiralMemory.addNextSquare(1)

        while (true) {
            val nextCoord = spiralMemory.nextEmptySquare()

            val sumAdjacent = nextCoord.adjacentCoordinates().mapNotNull { spiralMemory.getDataAt(it) }.sum()

            spiralMemory.addNextSquare(sumAdjacent)

            if (sumAdjacent > puzzleInput) {
                return sumAdjacent
            }
        }
    }
}