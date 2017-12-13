package days.day8

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day8Spec: Spek({

    describe("kotlin map plus") {
        it("works the way i think") {
            val map = mapOf("a" to 1, "b" to 3)
            val copy = map + mapOf("b" to 5)
            assertEquals(mapOf("a" to 1, "b" to 5), copy)
        }
    }

    given("the example input") {
        val rawInput = "b inc 5 if a > 1\n" +
                "a inc 1 if b < 5\n" +
                "c dec -10 if a >= 1\n" +
                "c inc -20 if c == 10"
        val exampleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for simple input") {
                    assertEquals(1, Part1.solve(exampleInput))
                }
            }
        }

        describe("Part 2") {

            describe("solve") {
                it("works for simple input") {
                    assertEquals(10, Part2.solve(exampleInput))
                }
            }
        }
    }
})
