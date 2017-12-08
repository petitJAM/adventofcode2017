package days.day3

import expect

object Shared {
    fun nearestOddSquareRoot(number: Int): Int {
        val sqrt = Math.sqrt(number.toDouble())
        val rounded = Math.floor(sqrt).toInt()

        return if (rounded % 2 == 0) {
            rounded - 1
        } else {
            rounded
        }
    }

    // region Tests

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

    // endregion Tests
}