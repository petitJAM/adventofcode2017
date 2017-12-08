package days.day3

class SpiralMemory<T> {

    private val squares = mutableListOf<Square>()

    fun getDataAt(coordinate: Coordinate): T? {
        return squares.firstOrNull { it.coordinate.x == coordinate.x && it.coordinate.y == coordinate.y }?.data
    }

    fun addNextSquare(data: T) {
        squares.add(Square(nextEmptySquare(), data))
    }

    fun nextEmptySquare(): Coordinate {
        if (squares.size == 0) {
            return Coordinate(0, 0)
        }

        val nextIndex = squares.size + 1

        val largestFullSquareSize = Shared.nearestOddSquareRoot(nextIndex)

        val startAtX = largestFullSquareSize / 2
        val startAtY = -largestFullSquareSize / 2

        val numberToMoveAfterStartAt = nextIndex - (largestFullSquareSize * largestFullSquareSize)
        if (numberToMoveAfterStartAt < 0) throw IllegalStateException("how did this happen")

        val sideLength = largestFullSquareSize + 1

        return when {
            numberToMoveAfterStartAt == 0 -> {
                Coordinate(startAtX, startAtY)
            }

            numberToMoveAfterStartAt <= sideLength * 1 -> {
                Coordinate(
                        startAtX + 1,
                        startAtY + (numberToMoveAfterStartAt - 1))
            }

            numberToMoveAfterStartAt <= sideLength * 2 -> {
                val numberToMoveAfterFirstCorner = numberToMoveAfterStartAt - sideLength
                Coordinate(
                        startAtX + 1 - numberToMoveAfterFirstCorner,
                        startAtY + largestFullSquareSize)
            }

            numberToMoveAfterStartAt <= sideLength * 3 -> {
                val numberToMoveAfterSecondCorner = numberToMoveAfterStartAt - (sideLength * 2)
                Coordinate(
                        startAtX + 1 - sideLength,
                        startAtY + largestFullSquareSize - numberToMoveAfterSecondCorner)
            }

            numberToMoveAfterStartAt <= sideLength * 4 -> {
                val numberToMoveAfterThirdCorner = numberToMoveAfterStartAt - (sideLength * 3)
                Coordinate(
                        startAtX + 1 - sideLength + numberToMoveAfterThirdCorner,
                        startAtY - 1)
            }

            else -> throw IllegalStateException("Shouldn't have gotten here")
        }
    }

    override fun toString(): String {
        val sortedGrid = squares
                .groupBy { it.coordinate.y }
                .values
                .sortedByDescending { it.first().coordinate.y }
                .map { it.sortedBy { it.coordinate.x } }

        val minXLength = squares.minBy { it.coordinate.x }?.data.toString().length
        val minYLength = squares.minBy { it.coordinate.y }?.data.toString().length
        val maxNumberLength = Math.max(minXLength, minYLength)

        val maxRowLength = (maxNumberLength + 1) * sortedGrid.last().size

        return sortedGrid.joinToString("\n") { column: List<Square> ->
            column.joinToString(" ") { square: Square ->
                square.data.toString().padStart(maxNumberLength)

            }.padStart(maxRowLength)
        }
    }

    data class Coordinate(val x: Int, val y: Int) {

        fun adjacentCoordinates(): List<Coordinate> {
            return listOf(
                    Coordinate(x - 1, y - 1),
                    Coordinate(x - 1, y + 0),
                    Coordinate(x - 1, y + 1),
                    Coordinate(x + 0, y - 1),
                    Coordinate(x + 0, y + 1),
                    Coordinate(x + 1, y - 1),
                    Coordinate(x + 1, y + 0),
                    Coordinate(x + 1, y + 1))
        }
    }

    inner class Square(val coordinate: Coordinate, val data: T)
}