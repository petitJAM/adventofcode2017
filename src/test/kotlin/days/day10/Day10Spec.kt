package days.day10

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day10Spec : Spek({

    xdescribe("kotlin List#subList") {
        it("works the way I think it does") {
            val expected = listOf(3, 4, 5)
            val actual = listOf(1, 2, 3, 4, 5, 6).subList(2, 5)
            assertEquals(expected, actual)
        }
    }

    given("the example input") {
        val rawInput = "3,4,1,5"
        val exampleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(12, Part1.solve(exampleInput, 5))
                }
            }
        }

        xdescribe("Part 2") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(0, Part2.solve(exampleInput))
                }
            }
        }
    }

    given("other input") {
        val rawInput = "5,2,4,1,5,3"
        val otherInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {

                it("works for the extra input") {
                    assertEquals(0, Part1.solve(otherInput, 6))
                }
            }

            describe("doNextKnot") {

                it("knots the circular list correctly") {
                    val expected = listOf(1, 0, 4, 2, 5, 3)
                    val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput, 0, 0)
                    assertEquals(expected, actual)
                }

                describe("it works for each step") {

                    it("works for first step") {
                        val expected = listOf(4, 3, 2, 1, 0, 5)
                        val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput.take(1), 0, 0)
                        assertEquals(expected, actual)
                    }

                    it("works for second step") {
                        val expected = listOf(5, 3, 2, 1, 0, 4)
                        val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput.take(2), 0, 0)
                        assertEquals(expected, actual)
                    }

                    it("works for third step") {
                        val expected = listOf(5, 3, 4, 0, 1, 2)
                        val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput.take(3), 0, 0)
                        assertEquals(expected, actual)
                    }

                    it("works for fourth step") {
                        val expected = listOf(5, 3, 4, 0, 1, 2)
                        val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput.take(4), 0, 0)
                        assertEquals(expected, actual)
                    }

                    it("works for fifth step") {
                        val expected = listOf(1, 0, 4, 3, 5, 2)
                        val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput.take(5), 0, 0)
                        assertEquals(expected, actual)
                    }

                    it("works for sixth step") {
                        val expected = listOf(1, 0, 4, 2, 5, 3)
                        val actual = Part1.doNextKnot(listOf(0, 1, 2, 3, 4, 5), otherInput.take(6), 0, 0)
                        assertEquals(expected, actual)
                    }
                }
            }
        }
    }
})
