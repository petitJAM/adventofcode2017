package days.day14

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day14Spec : Spek({

    given("the example input") {
        val rawInput = ""
        val exampleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(0, Part1.solve(exampleInput))
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
})
