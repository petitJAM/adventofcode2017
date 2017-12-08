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

    describe("nextEmptySquare") {

        fun addSquares(num: Int) {
            num.times { subject.addNextSquare(1) }
        }

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
    }
})