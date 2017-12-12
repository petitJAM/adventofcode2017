package days.day7

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class MethodsSpec : Spek({

    describe("buildTree") {

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
            val bottomProgram = findBottomProgram(puzzleInput) ?: throw Error("bad test data")

            it("builds a Node from the list") {
                val expected = Node(
                        Program("tknk", 41, listOf("ugml", "padx", "fwft")),
                        listOf(
                                Node(Program("ugml", 68, listOf("gyxo", "ebii", "jptl")),
                                        listOf(
                                                Node(Program("gyxo", 61)),
                                                Node(Program("ebii", 61)),
                                                Node(Program("jptl", 61))
                                        )),
                                Node(Program("padx", 45, listOf("pbga", "havc", "qoyq")),
                                        listOf(
                                                Node(Program("pbga", 66)),
                                                Node(Program("havc", 66)),
                                                Node(Program("qoyq", 66))
                                        )),
                                Node(Program("fwft", 72, listOf("ktlj", "cntj", "xhth")),
                                        listOf(
                                                Node(Program("ktlj", 57)),
                                                Node(Program("cntj", 57)),
                                                Node(Program("xhth", 57))))))
                val actual = buildTree(bottomProgram, puzzleInput)
                assertEquals(expected, actual)
            }
        }
    }

    describe("Node<Program>.totalWeight") {
        given("simple input") {
            val simpleInput =
                    Node(Program("abc", 5, listOf("def", "ghi")),
                            listOf(
                                    Node(Program("def", 7)),
                                    Node(Program("ghi", 3, listOf("jkl", "mno")),
                                            listOf(
                                                    Node(Program("jkl", 8)),
                                                    Node(Program("mno", 4))))))

            it("counts the total weight of all nodes") {
                assertEquals(27, simpleInput.totalWeight)
            }
        }
    }
})