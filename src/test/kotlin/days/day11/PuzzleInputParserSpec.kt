package days.day11

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

        given("the example inputs") {

            val exampleInput1 = "ne,ne,ne"
            val exampleInput2 = "ne,ne,sw,sw"
            val exampleInput3 = "ne,ne,s,s"
            val exampleInput4 = "se,sw,se,sw,sw"

            it("works for example input 1") {
                val expected = listOf("ne", "ne", "ne")
                assertEquals(expected, PuzzleInputParser.parse(exampleInput1))
            }

            it("works for example input 1") {
                val expected = listOf("ne", "ne", "sw", "sw")
                assertEquals(expected, PuzzleInputParser.parse(exampleInput2))
            }

            it("works for example input 1") {
                val expected = listOf("ne", "ne", "s", "s")
                assertEquals(expected, PuzzleInputParser.parse(exampleInput3))
            }

            it("works for example input 1") {
                val expected = listOf("se", "sw", "se", "sw", "sw")
                assertEquals(expected, PuzzleInputParser.parse(exampleInput4
                ))
            }
        }
    }
})
