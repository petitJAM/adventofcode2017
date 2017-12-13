package days.day8

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
class PuzzleInputParseSpec: Spek({

    describe("parse") {

        given("the example input") {

            val exampleInput = "b inc 5 if a > 1\n" +
                    "a inc 1 if b < 5\n" +
                    "c dec -10 if a >= 1\n" +
                    "c inc -20 if c == 10"

            it("creates a list of instructions") {
                val expected = listOf(
                        Instruction("b", Operation.Inc, 5, Condition("a", Comparison.GreaterThan, 1)),
                        Instruction("a", Operation.Inc, 1, Condition("b", Comparison.LessThan, 5)),
                        Instruction("c", Operation.Dec, -10, Condition("a", Comparison.GreaterThanOrEqualTo, 1)),
                        Instruction("c", Operation.Inc, -20, Condition("c", Comparison.EqualTo, 10)))

                assertEquals(expected, PuzzleInputParser.parse(exampleInput))
            }
        }
    }
})