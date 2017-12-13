package days.day8

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day8Spec: Spek({

    describe("Part 1") {

        describe("solve") {
            it("works for simple input") {
                assertEquals(0, Part1.solve(0))
            }
        }
    }

    describe("Part 2") {

        describe("solve") {
            it("works for simple input") {
                assertEquals(0, Part2.solve(0))
            }
        }
    }
})
