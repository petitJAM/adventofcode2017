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

        xdescribe("Part 2") {

            describe("solve") {
                it("works for simple input") {
                    assertEquals(0, Part2.solve(exampleInput1))
                }
            }
        }
    }
})
