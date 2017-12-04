package days

import expect

object Day3 {

    fun run() {
        println("Day 3")

        println("Part 1")
        println(solve(325489))

//        testManhattenDistance()
//        testNearestOddSquareRoot()
//        testFindSpiralMemoryCoordinate()
//        testSolve()
    }

    fun solve(input: Int): Int {
        return manhattenDistance(Point(0, 0), findSpiralMemoryCoordinate(input))
    }

    private data class Point(val x: Int, val y: Int)

    private fun findSpiralMemoryCoordinate(num: Int): Point {

        val largestFullSquareSize = nearestOddSquareRoot(num)

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

    private fun nearestOddSquareRoot(number: Int): Int {
        val sqrt = Math.sqrt(number.toDouble())
        val rounded = Math.floor(sqrt).toInt()

        return if (rounded % 2 == 0) {
            rounded - 1
        } else {
            rounded
        }
    }

    private fun manhattenDistance(a: Point, b: Point): Int {
        return Math.abs(a.x - b.x) + Math.abs(a.y - b.y)
    }

    // region Tests

    private fun testSolve() {
        expect { solve(1) }.toEqual(0)
        expect { solve(12) }.toEqual(3)
        expect { solve(23) }.toEqual(2)
        expect { solve(1024) }.toEqual(31)
    }

    private fun testNearestOddSquareRoot() {
        expect {
            nearestOddSquareRoot(1)
        }.toEqual(1)

        expect {
            nearestOddSquareRoot(5)
        }.toEqual(1)

        expect {
            nearestOddSquareRoot(9)
        }.toEqual(3)

        expect {
            nearestOddSquareRoot(15)
        }.toEqual(3)

        expect {
            nearestOddSquareRoot(25)
        }.toEqual(5)

        expect {
            nearestOddSquareRoot(27)
        }.toEqual(5)

        expect {
            nearestOddSquareRoot(49)
        }.toEqual(7)

        expect {
            nearestOddSquareRoot(80)
        }.toEqual(7)

        expect {
            nearestOddSquareRoot(81)
        }.toEqual(9)

        expect {
            nearestOddSquareRoot(100)
        }.toEqual(9)

        println()
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

    private fun testManhattenDistance() {
        expect {
            manhattenDistance(Point(0, 0), Point(1, 1))
        }.toEqual(2)

        expect {
            manhattenDistance(Point(0, 0), Point(2, 2))
        }.toEqual(4)

        expect {
            manhattenDistance(Point(0, 0), Point(0, 50))
        }.toEqual(50)

        expect {
            manhattenDistance(Point(0, 0), Point(72, 0))
        }.toEqual(72)

        expect {
            manhattenDistance(Point(-8, 4), Point(3, -5))
        }.toEqual(20)

        println()
    }

    // endregion Tests
}