package days.day9

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day9Spec: Spek({

    given("the example inputs") {
        val exampleInput1 = "{}"
        val exampleInput2 = "{{{}}}"
        val exampleInput3 = "{{},{}}"
        val exampleInput4 = "{{{},{},{{}}}}"
        val exampleInput5 = "{<a>,<a>,<a>,<a>}"
        val exampleInput6 = "{{<ab>},{<ab>},{<ab>},{<ab>}}"
        val exampleInput7 = "{{<!!>},{<!!>},{<!!>},{<!!>}}"
        val exampleInput8 = "{{<a!>},{<a!>},{<a!>},{<ab>}}"

        describe("Part 1") {

            describe("solve") {

                it("works for example input 1") {
                    assertEquals(1, Part1.solve(exampleInput1))
                }

                it("works for example input 2") {
                    assertEquals(6, Part1.solve(exampleInput2))
                }

                it("works for example input 3") {
                    assertEquals(5, Part1.solve(exampleInput3))
                }

                it("works for example input 4") {
                    assertEquals(16, Part1.solve(exampleInput4))
                }

                it("works for example input 5") {
                    assertEquals(1, Part1.solve(exampleInput5))
                }

                it("works for example input 6") {
                    assertEquals(9, Part1.solve(exampleInput6))
                }

                it("works for example input 7") {
                    assertEquals(9, Part1.solve(exampleInput7))
                }

                it("works for example input 8") {
                    assertEquals(3, Part1.solve(exampleInput8))
                }
            }
        }

        describe("Part 2") {

            describe("solve") {
                it("works for example input 1") {
                    assertEquals(0, Part2.solve(exampleInput1))
                }

                it("works for example input 2") {
                    assertEquals(0, Part2.solve(exampleInput2))
                }

                it("works for example input 3") {
                    assertEquals(0, Part2.solve(exampleInput3))
                }

                it("works for example input 4") {
                    assertEquals(0, Part2.solve(exampleInput4))
                }

                it("works for example input 5") {
                    assertEquals(4, Part2.solve(exampleInput5))
                }

                it("works for example input 6") {
                    assertEquals(8, Part2.solve(exampleInput6))
                }

                it("works for example input 7") {
                    assertEquals(0, Part2.solve(exampleInput7))
                }

                it("works for example input 8") {
                    assertEquals(17, Part2.solve(exampleInput8))
                }
            }

            given("extra examples") {
                val extraInput1 = "{<>}"
                val extraInput2 = "{<random characters>}"
                val extraInput3 = "{<<<<>}"
                val extraInput4 = "{<{!>}>}"
                val extraInput5 = "{<!!>}"
                val extraInput6 = "{<!!!>>}"
                val extraInput7 = "{<{o\"i!a,<{i<a>}"

                describe("solve") {
                    it("works for extra input 1") {
                        assertEquals(0, Part2.solve(extraInput1))
                    }

                    it("works for extra input 2") {
                        assertEquals(17, Part2.solve(extraInput2))
                    }

                    it("works for extra input 3") {
                        assertEquals(3, Part2.solve(extraInput3))
                    }

                    it("works for extra input 4") {
                        assertEquals(2, Part2.solve(extraInput4))
                    }

                    it("works for extra input 5") {
                        assertEquals(0, Part2.solve(extraInput5))
                    }

                    it("works for extra input 6") {
                        assertEquals(0, Part2.solve(extraInput6))
                    }

                    it("works for extra input 7") {
                        assertEquals(10, Part2.solve(extraInput7))
                    }
                }
            }
        }
    }
})
