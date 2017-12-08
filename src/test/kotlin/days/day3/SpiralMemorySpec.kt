package days.day3

import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.subject.SubjectSpek
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import times
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class SpiralMemorySpec: SubjectSpek<SpiralMemory<Int>>({
    subject { SpiralMemory() }

    fun addSquares(num: Int) {
        num.times { subject.addNextSquare(it) }
    }

    describe("getDataAt when the squares have sequential numbers") {

        beforeEachTest {
            addSquares(100)
        }

        it("returns 1 at 0,0") {
            assertEquals(subject.getDataAt(0, 0), 1)
        }

        it("returns 2 at 1,0") {
            assertEquals(subject.getDataAt(1, 0), 2)
        }

        it("returns 3 at 1,1") {
            assertEquals(subject.getDataAt(1, 1), 3)
        }

        it("returns 20 at -2,-1") {
            assertEquals(subject.getDataAt(-2, -1), 20)
        }

        it("returns 43 at -3,-3") {
            assertEquals(subject.getDataAt(-3, -3), 43)
        }
    }

    describe("nextEmptySquare") {

        it("returns 0,0 when the memory is empty") {
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(0, 0))
        }

        it("returns 1,0 when there is one item in it") {
            addSquares(1)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(1, 0))
        }

        it("returns 1,1 when there are two items in it") {
            addSquares(2)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(1, 1))
        }

        it("returns 0,1 when there are 3 items in it") {
            addSquares(3)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(0, 1))
        }

        it("returns -1,1 when there are 4 items in it") {
            addSquares(4)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(-1, 1))
        }

        it("returns -1,0 when there are 5 items in it") {
            addSquares(5)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(-1, 0))
        }

        it("returns -1,-1 when there are 6 items in it") {
            addSquares(6)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(-1, -1))
        }

        it("returns 0,-1 when there are 7 items in it") {
            addSquares(7)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(0, -1))
        }

        it("returns 3,1 when there are 28 items in it") {
            addSquares(28)
            assertEquals(subject.nextEmptySquare(),
                    SpiralMemory.Coordinate(3, 1))
        }
    }
})