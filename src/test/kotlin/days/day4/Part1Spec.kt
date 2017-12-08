package days.day4

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object Part1Spec: Spek({

    describe("solve") {

        it("works on an input") {
            val input = listOf(
                    "aa bb cc dd ee",
                    "aa bb cc dd aa",
                    "aa bb cc dd aaa")
            assertEquals(Part1.solve(input), 2)
        }
    }
})