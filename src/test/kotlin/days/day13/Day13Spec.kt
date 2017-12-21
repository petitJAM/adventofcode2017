package days.day13

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day13Spec : Spek({

    given("the example input") {
        val rawInput = """
            |0: 3
            |1: 2
            |4: 4
            |6: 4
            """.trimMargin()

        val exampleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(24, Part1.solve(exampleInput))
                }
            }
        }

        describe("Part 2") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(10, Part2.solve(exampleInput))
                }
            }
        }
    }
})
