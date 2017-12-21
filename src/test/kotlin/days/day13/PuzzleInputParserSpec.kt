package days.day13

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
            val exampleInput = """
                    |0: 3
                    |1: 2
                    |4: 4
                    |6: 4
                    """.trimMargin()

            it("creates a list of instructions") {
                val expected = mapOf(
                        0 to 3,
                        1 to 2,
                        4 to 4,
                        6 to 4)
                assertEquals(expected, PuzzleInputParser.parse(exampleInput))
            }
        }
    }
})
