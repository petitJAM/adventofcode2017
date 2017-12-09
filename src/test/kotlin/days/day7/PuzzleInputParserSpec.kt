package days.day7

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.math.exp
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class PuzzleInputParserSpec : Spek({

    describe("parse") {

        given("a puzzle input") {

            it("parses it into a useable format") {
                val input = "pbga (66)\n" +
                        "xhth (57)\n" +
                        "ebii (61)\n" +
                        "havc (66)\n" +
                        "ktlj (57)\n" +
                        "fwft (72) -> ktlj, cntj, xhth\n" +
                        "qoyq (66)\n" +
                        "padx (45) -> pbga, havc, qoyq\n" +
                        "tknk (41) -> ugml, padx, fwft\n" +
                        "jptl (61)\n" +
                        "ugml (68) -> gyxo, ebii, jptl\n" +
                        "gyxo (61)\n" +
                        "cntj (57)"

                val expected = listOf(
                        Program("pbga", 66),
                        Program("xhth", 57),
                        Program("ebii", 61),
                        Program("havc", 66),
                        Program("ktlj", 57),
                        Program("fwft", 72, listOf("ktlj", "cntj", "xhth")),
                        Program("qoyq", 66),
                        Program("padx", 45, listOf("pbga", "havc", "qoyq")),
                        Program("tknk", 41, listOf("ugml", "padx", "fwft")),
                        Program("jptl", 61),
                        Program("ugml", 68, listOf("gyxo", "ebii", "jptl")),
                        Program("gyxo", 61),
                        Program("cntj", 57))

                val actual = PuzzleInputParser.parse(input)

                assertEquals(expected, actual)
            }
        }
    }
})