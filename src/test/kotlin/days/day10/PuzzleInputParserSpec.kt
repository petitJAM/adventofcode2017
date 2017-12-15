package days.day10

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class PuzzleInputParserSpec : Spek({

    describe("parse") {

        given("the example input") {

            val exampleInput = "3,4,1,5"

            it("creates a list of instructions") {
                val expected = listOf(3, 4, 1, 5)
                assertEquals(expected, PuzzleInputParser.parse(exampleInput))
            }
        }
    }
})
