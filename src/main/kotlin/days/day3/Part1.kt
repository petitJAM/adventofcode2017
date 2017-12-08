package days.day3

import expect

object Part1 {

    fun solve(input: Int): Int {
        return manhattanDistance(Point(0, 0), findSpiralMemoryCoordinate(input))
    }

    fun test() {
        testManhattanDistance()
        testFindSpiralMemoryCoordinate()
        testSolve()
    }

    private fun findSpiralMemoryCoordinate(num: Int): Point {

        val largestFullSquareSize = Shared.nearestOddSquareRoot(num)

        val startAtX = largestFullSquareSize / 2
        val startAtY = -largestFullSquareSize / 2

        val numberToMoveAfterStartAt = num - (largestFullSquareSize * largestFullSquareSize)

        if (numberToMoveAfterStartAt < 0) throw IllegalStateException("how did this happen")

        val sideLength = largestFullSquareSize + 1

        return when {

            numberToMoveAfterStartAt == 0 -> {
                Point(startAtX, startAtY)
            }

            numberToMoveAfterStartAt <= sideLength * 1 -> {
                Point(
                        startAtX + 1,
                        startAtY + (numberToMoveAfterStartAt - 1))
            }

            numberToMoveAfterStartAt <= sideLength * 2 -> {
                val numberToMoveAfterFirstCorner = numberToMoveAfterStartAt - sideLength
                Point(
                        startAtX + 1 - numberToMoveAfterFirstCorner,
                        startAtY + largestFullSquareSize)
            }

            numberToMoveAfterStartAt <= sideLength * 3 -> {
                val numberToMoveAfterSecondCorner = numberToMoveAfterStartAt - (sideLength * 2)
                Point(
                        startAtX + 1 - sideLength,
                        startAtY + largestFullSquareSize - numberToMoveAfterSecondCorner)
            }

            numberToMoveAfterStartAt <= sideLength * 4 -> {
                val numberToMoveAfterThirdCorner = numberToMoveAfterStartAt - (sideLength * 3)
                Point(
                        startAtX + 1 - sideLength + numberToMoveAfterThirdCorner,
                        startAtY - 1)
            }

            else -> throw IllegalStateException("Shouldn't be able to get to this case")
        }
    }

    private fun manhattanDistance(a: Point, b: Point): Int {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y)
    }

    // region Tests

    private fun testSolve() {
        expect { solve(1) }.toEqual(0)
        expect { solve(12) }.toEqual(3)
        expect { solve(23) }.toEqual(2)
        expect { solve(1024) }.toEqual(31)
    }

    private fun testFindSpiralMemoryCoordinate() {
        expect {
            findSpiralMemoryCoordinate(1)
        }.toEqual(Point(0, 0))

        expect {
            findSpiralMemoryCoordinate(2)
        }.toEqual(Point(1, 0))

        expect {
            findSpiralMemoryCoordinate(3)
        }.toEqual(Point(1, 1))

        expect {
            findSpiralMemoryCoordinate(4)
        }.toEqual(Point(0, 1))

        expect {
            findSpiralMemoryCoordinate(9)
        }.toEqual(Point(1, -1))

        expect {
            findSpiralMemoryCoordinate(10)
        }.toEqual(Point(2, -1))

        expect {
            findSpiralMemoryCoordinate(13)
        }.toEqual(Point(2, 2))

        expect {
            findSpiralMemoryCoordinate(14)
        }.toEqual(Point(1, 2))

        expect {
            findSpiralMemoryCoordinate(17)
        }.toEqual(Point(-2, 2))

        expect {
            findSpiralMemoryCoordinate(18)
        }.toEqual(Point(-2, 1))

        expect {
            findSpiralMemoryCoordinate(31)
        }.toEqual(Point(3, 3))

        expect {
            findSpiralMemoryCoordinate(21)
        }.toEqual(Point(-2, -2))

        expect {
            findSpiralMemoryCoordinate(22)
        }.toEqual(Point(-1, -2))

        expect {
            findSpiralMemoryCoordinate(24)
        }.toEqual(Point(1, -2))

        println()
    }

    private fun testManhattanDistance() {
        expect {
            manhattanDistance(Point(0, 0), Point(1, 1))
        }.toEqual(2)

        expect {
            manhattanDistance(Point(0, 0), Point(2, 2))
        }.toEqual(4)

        expect {
            manhattanDistance(Point(0, 0), Point(0, 50))
        }.toEqual(50)

        expect {
            manhattanDistance(Point(0, 0), Point(72, 0))
        }.toEqual(72)

        expect {
            manhattanDistance(Point(-8, 4), Point(3, -5))
        }.toEqual(20)

        println()
    }

    // endregion Tests
}