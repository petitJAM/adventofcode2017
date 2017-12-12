package days.day7

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day7Spec: Spek({

    given("the example input") {
        val rawInput = "pbga (66)\n" +
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
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for simple input") {
                    assertEquals("tknk", Part1.solve(puzzleInput))
                }
            }
        }

        describe("Part 2") {

            describe("solve") {
                it("works for simple input") {
                    assertEquals(60, Part2.solve(puzzleInput))
                }
            }
        }
    }

})
