package days.day10

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day10Spec : Spek({

    describe("kotlin List#subList") {
        it("works the way I think it does") {
            val expected = listOf(3, 4, 5)
            val actual = listOf(1, 2, 3, 4, 5, 6).subList(2, 5)
            assertEquals(expected, actual)
        }
    }

    describe("bytes") {
        it("works how I think it does") {
            val expected = listOf(49.toByte(), 44.toByte(), 50.toByte(), 44.toByte(), 51.toByte())
            val input = "1,2,3"
            assertEquals(expected, input.toCharArray().map { it.toByte() })
        }
    }

    describe("groupBy") {
        it("works how I think it does") {
            val expected = listOf(
                    listOf(4, 6, 7),
                    listOf(3, 9, 2),
                    listOf(1, 5, 8))
            val actual = listOf(4, 6, 7, 3, 9, 2, 1, 5, 8).withIndex().groupBy { it.index / 3 }.values.map { it.map { it.value } }

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
    }

    given("different example input") {

        describe("Part 2") {

            describe("saltedLengths") {

                it("works for the example input") {
                    val expected = listOf(49, 44, 50, 44, 51, 17, 31, 73, 47, 23)
                    assertEquals(expected, Part2.saltedLengths("1,2,3"))
                }
            }

            describe("splitToBlocks") {

                it("works for some input") {
                    val expected = listOf(
                            listOf(4, 6, 7),
                            listOf(3, 9, 2),
                            listOf(1, 5, 8))
                    val input = listOf(4, 6, 7, 3, 9, 2, 1, 5, 8)
                    assertEquals(expected, Part2.splitToBlocks(input, 3))
                }

                it("works for some other input") {
                    val expected = listOf(
                            listOf(5, 6, 7, 8),
                            listOf(3, 4, 5, 6),
                            listOf(8, 9, 7, 1))
                    val input = listOf(5, 6, 7, 8, 3, 4, 5, 6, 8, 9, 7, 1)
                    assertEquals(expected, Part2.splitToBlocks(input, 4))
                }
            }

            describe("solve") {
                val exampleInput1 = ""
                val exampleInput2 = "AoC 2017"
                val exampleInput3 = "1,2,3"
                val exampleInput4 = "1,2,4"

                it("works for example input 1") {
                    assertEquals("a2582a3a0e66e6e86e3812dcb672a272", Part2.solve(exampleInput1))
                }

                it("works for example input 2") {
                    assertEquals("33efeb34ea91902bb2f59c9920caa6cd", Part2.solve(exampleInput2))
                }

                it("works for example input 3") {
                    assertEquals("3efbe78a8d82f29979031a4aa0b16a9d", Part2.solve(exampleInput3))
                }

                it("works for example input 4") {
                    assertEquals("63960835bcdc130f0b66d7ff4f6a5a8e", Part2.solve(exampleInput4))
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
