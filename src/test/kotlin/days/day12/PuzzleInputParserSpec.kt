package days.day12

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
                    |0 <-> 2
                    |1 <-> 1
                    |2 <-> 0, 3, 4
                    |3 <-> 2, 4
                    |4 <-> 2, 3, 6
                    |5 <-> 6
                    |6 <-> 4, 5
                    """.trimMargin()

            it("creates a list of programs and their neighbors") {
                val expected = mapOf(
                        0 to listOf(2),
                        1 to listOf(1),
                        2 to listOf(0, 3, 4),
                        3 to listOf(2, 4),
                        4 to listOf(2, 3, 6),
                        5 to listOf(6),
                        6 to listOf(4, 5))
                assertEquals(expected, PuzzleInputParser.parse(exampleInput))
            }
        }
    }
})
