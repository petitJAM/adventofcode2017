package days.day3

import expect

object Part2 {

    fun solve(puzzleInput: Int): Int {

        val spiralMemory = SpiralMemory<Int>()

        spiralMemory.addNextSquare(1)

        while (true) {
            val nextCoord = spiralMemory.nextEmptySquare()

            val sumAdjacent = nextCoord.adjacentCoordinates().mapNotNull { spiralMemory.getDataAt(it) }.sum()

            spiralMemory.addNextSquare(sumAdjacent)

            println(spiralMemory.toString())

            if (sumAdjacent > puzzleInput) {
                return sumAdjacent
            }
        }
    }

    fun test() {
        testSolve()
    }

    // region Tests

    private fun testSolve() {
        expect {
            solve(-1)
        }.toEqual(1)

        expect {
            solve(0)
        }.toEqual(1)

        expect {
            solve(1)
        }.toEqual(2)

        expect {
            solve(2)
        }.toEqual(3)

        expect {
            solve(3)
        }.toEqual(4)

        expect {
            solve(4)
        }.toEqual(5)

        expect {
            solve(5)
        }.toEqual(10)

        expect {
            solve(6)
        }.toEqual(10)

        expect {
            solve(9)
        }.toEqual(10)

        expect {
            solve(10)
        }.toEqual(11)

        expect {
            solve(15)
        }.toEqual(23)

        expect {
            solve(24)
        }.toEqual(25)

        expect {
            solve(25)
        }.toEqual(26)

        expect {
            solve(30)
        }.toEqual(54)

        expect {
            solve(56)
        }.toEqual(57)

        expect {
            solve(70)
        }.toEqual(122)
    }

    // endregion Tests
}