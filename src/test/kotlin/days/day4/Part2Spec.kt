package days.day4

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import kotlin.test.assertEquals

object Part2Spec: Spek({

    describe("solve") {

        it("works on an input") {
            val input = listOf(
                    "abcde fghij",
                    "abcde xyz ecdab",
                    "a ab abc abd abf abj",
                    "iiii oiii oooi oooo",
                    "oiii ioii iioi iiio")
            assertEquals(3, Part2.solve(input))
        }
    }
})