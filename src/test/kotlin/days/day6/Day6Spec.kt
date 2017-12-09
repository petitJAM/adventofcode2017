package days.day6

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day6Spec: Spek({

    describe("Part 1") {

        describe("solve") {
            it("works for simple input") {
                assertEquals(5, Part1.solve(listOf(0, 2, 7, 0)))
            }
        }
    }

    describe("Part 2") {

        describe("solve") {
            it("works for simple input") {
                assertEquals(4, Part2.solve(listOf(0, 2, 7, 0)))
            }
        }
    }
})
