package days.day12

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day12Spec : Spek({

    given("the example input") {
        val rawInput = """
                |0 <-> 2
                |1 <-> 1
                |2 <-> 0, 3, 4
                |3 <-> 2, 4
                |4 <-> 2, 3, 6
                |5 <-> 6
                |6 <-> 4, 5
                """.trimMargin()
        val exampleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(6, Part1.solve(exampleInput))
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

    given("extra input") {
        val rawInput = """
            |0 <-> 3, 4
            |1 <-> 2, 3
            |2 <-> 1
            |3 <-> 0, 1, 4
            |4 <-> 0, 3
            |5 <-> 6, 7
            |6 <-> 5
            |7 <-> 5, 8
            |8 <-> 7
            """.trimMargin()
        val extraInput = PuzzleInputParser.parse(rawInput)

        describe("solve") {
            it("works for the extra input") {
                assertEquals(5, Part1.solve(extraInput))
            }
        }
    }
})
