package days.day11

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day11Spec : Spek({

    given("the example input") {

        val rawInput1 = "ne,ne,ne"
        val rawInput2 = "ne,ne,sw,sw"
        val rawInput3 = "ne,ne,s,s"
        val rawInput4 = "se,sw,se,sw,sw"
        val exampleInput1 = PuzzleInputParser.parse(rawInput1)
        val exampleInput2 = PuzzleInputParser.parse(rawInput2)
        val exampleInput3 = PuzzleInputParser.parse(rawInput3)
        val exampleInput4 = PuzzleInputParser.parse(rawInput4)

        describe("Part 1") {

            describe("solve") {
                it("works for example input 1") {
                    assertEquals(3, Part1.solve(exampleInput1))
                }

                it("works for example input 2") {
                    assertEquals(0, Part1.solve(exampleInput2))
                }

                it("works for example input 3") {
                    assertEquals(2, Part1.solve(exampleInput3))
                }

                it("works for example input 4") {
                    assertEquals(3, Part1.solve(exampleInput4))
                }
            }
        }

        xdescribe("Part 2") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(0, Part2.solve(exampleInput1))
                }
            }
        }
    }
})
