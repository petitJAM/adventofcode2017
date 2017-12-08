package days.day5

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object Day5Spec: Spek({

    describe("Part 1") {

        describe("solve") {
            it("works for simple input") {
                val input = listOf(0, 3, 0, 1, -3)
                assertEquals(5, Part1.solve(input))
            }
        }
    }

    describe("Part 2") {

        describe("solve") {
            it("works for simple input") {
                Part2.solve(emptyList())
            }
        }
    }
})