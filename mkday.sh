#!/bin/bash

if [ -z "$1" ]
then
  echo "No day number given"
  exit 1
fi

day=$1
export day

mkdir -p "src/main/kotlin/days/day$day"
mkdir -p "src/test/kotlin/days/day$day"

touch "src/main/resources/puzzleInputs/day$day.txt"

cat << EOF > "src/main/kotlin/days/day$day/Day$day.kt"
package days.day$day

import days.Day
import util.PuzzleInputReader

@Suppress("unused")
object Day$day : Day {

    override fun run() {
        val rawInput = PuzzleInputReader("puzzleInputs/day$day.txt").readFile()
        val puzzleInput = PuzzleInputParser.parse(rawInput)

        println("Part 1")
        println(Part1.solve(puzzleInput))

        println("Part 2")
        println(Part2.solve(puzzleInput))
    }
}
EOF

cat << EOF > "src/main/kotlin/days/day$day/Part1.kt"
package days.day$day

object Part1 {

    fun solve(puzzleInput: Any): Any {
        TODO()
    }
}
EOF

cat << EOF > "src/main/kotlin/days/day$day/Part2.kt"
package days.day$day

object Part2 {

    fun solve(puzzleInput: Any): Any {
        TODO()
    }
}
EOF

cat << EOF > "src/main/kotlin/days/day$day/PuzzleInputParser.kt"
package days.day$day

object PuzzleInputParser {

    fun parse(puzzleInput: String): Any {
        TODO()
    }
}
EOF

cat << EOF > "src/test/kotlin/days/day$day/Day${day}Spec.kt"
package days.day$day

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.given
import org.jetbrains.spek.api.dsl.it
import org.jetbrains.spek.api.dsl.xdescribe
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals

@RunWith(JUnitPlatform::class)
object Day${day}Spec : Spek({

    given("the example input") {
        val rawInput = ""
        val exampleInput = PuzzleInputParser.parse(rawInput)

        describe("Part 1") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(0, Part1.solve(exampleInput))
                }
            }
        }

        xdescribe("Part 2") {

            describe("solve") {
                it("works for the example input") {
                    assertEquals(0, Part2.solve(exampleInput))
                }
            }
        }
    }
})
EOF

cat << EOF > "src/test/kotlin/days/day$day/PuzzleInputParserSpec.kt"
package days.day$day

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

            val exampleInput = ""

            it("creates a list of instructions") {
                val expected = Any()
                assertEquals(expected, PuzzleInputParser.parse(exampleInput))
            }
        }
    }
})
EOF