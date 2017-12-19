package days.day11

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.*
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@RunWith(JUnitPlatform::class)
object Day11Spec : Spek({

    given("the example input") {

        val rawInput1 = "ne,ne,ne"
        val rawInput2 = "ne,ne,sw,sw"
        val rawInput3 = "ne,ne,s,s"
        val rawInput4 = "se,sw,se,sw,sw"
        val exampleInput1 = PuzzleInputParser.parse(rawInput1)
        val exampleInput2 = PuzzleInputParser.parse(rawInput2)
        val exampleInput3 = PuzzleInputParser.parse(rawInput3)
        val exampleInput4 = PuzzleInputParser.parse(rawInput4)

        describe("Part 1") {

            describe("solve") {
                it("works for example input 1") {
                    assertEquals(3, Part1.solve(exampleInput1))
                }

                it("works for example input 2") {
                    assertEquals(0, Part1.solve(exampleInput2))
                }

                it("works for example input 3") {
                    assertEquals(2, Part1.solve(exampleInput3))
                }

                it("works for example input 4") {
                    assertEquals(3, Part1.solve(exampleInput4))
                }
            }

            describe("directionToHexCoordinate") {
                it("works for all possible directions") {
                    assertEquals(AxialCoordinate(0, -1), directionToHexCoordinate("n"))
                    assertEquals(AxialCoordinate(-1, 0), directionToHexCoordinate("nw"))
                    assertEquals(AxialCoordinate(1, -1), directionToHexCoordinate("ne"))
                    assertEquals(AxialCoordinate(0, 1), directionToHexCoordinate("s"))
                    assertEquals(AxialCoordinate(-1, 1), directionToHexCoordinate("sw"))
                    assertEquals(AxialCoordinate(1, 0), directionToHexCoordinate("se"))
                }

                it("throws an error if you give it bad input") {
                    assertFailsWith(IllegalArgumentException::class) {
                        directionToHexCoordinate("bad dir")
                    }
                }
            }
        }

        describe("Part 2") {

            describe("solve") {
                it("works for the example input 1") {
                    assertEquals(3, Part2.solve(exampleInput1))
                }

                it("works for the example input 2") {
                    assertEquals(2, Part2.solve(exampleInput2))
                }

                it("works for the example input 3") {
                    assertEquals(2, Part2.solve(exampleInput3))
                }

                it("works for the example input 4") {
                    assertEquals(3, Part2.solve(exampleInput4))
                }

                it("works for an extra input") {
                    val extraInput = PuzzleInputParser.parse("n,n,ne,ne,s,sw")
                    assertEquals(4, Part2.solve(extraInput))
                }
            }
        }
    }

    describe("HexCoordinateMethods") {

        describe("axialToCube") {

            it("converts 0,0 -> 0,0,0") {
                assertEquals(CubeCoordinate(0, 0, 0), axialToCube(AxialCoordinate(0, 0)))
            }

            // n
            it("converts 0,-1 -> 0,1,-1") {
                assertEquals(CubeCoordinate(0, 1, -1), axialToCube(AxialCoordinate(0, -1)))
            }

            // nw
            it("converts -1,0 -> -1,1,0") {
                assertEquals(CubeCoordinate(-1, 1, 0), axialToCube(AxialCoordinate(-1, 0)))
            }

            // ne
            it("converts 1,-1 ->  1,0,-1") {
                assertEquals(CubeCoordinate(1, 0, -1), axialToCube(AxialCoordinate(1, -1)))
            }

            // s
            it("converts 0,1 -> 0,-1,1") {
                assertEquals(CubeCoordinate(0, -1, 1), axialToCube(AxialCoordinate(0, 1)))
            }

            // sw
            it("converts -1,1 -> -1,0,1") {
                assertEquals(CubeCoordinate(-1, 0, 1), axialToCube(AxialCoordinate(-1, 1)))
            }

            // se
            it("converts 1,0 -> 1,-1,0") {
                assertEquals(CubeCoordinate(1, -1, 0), axialToCube(AxialCoordinate(1, 0)))
            }
        }

        describe("distance (cube)") {

            it("works for 0,0,0 -> 0,0,0") {
                val p0 = CubeCoordinate(0, 0, 0)
                val p1 = CubeCoordinate(0, 0, 0)
                assertEquals(0, distance(p0, p1))
            }

            it("works for 0,0,0 -> 1,0,-1") {
                val p0 = CubeCoordinate(0, 0, 0)
                val p1 = CubeCoordinate(1, 0, -1)
                assertEquals(1, distance(p0, p1))
            }

            it("works for 0,0,0 -> 1,-1,0") {
                val p0 = CubeCoordinate(0, 0, 0)
                val p1 = CubeCoordinate(1, -1, 0)
                assertEquals(1, distance(p0, p1))
            }

            it("works for 0,0,0 -> 2,1,-3") {
                val p0 = CubeCoordinate(0,0,0)
                val p1 = CubeCoordinate(2,1,-3)
                assertEquals(3, distance(p0, p1))
            }
        }

        describe("distance (axial)") {

            it("works for 0,0 -> 0,0") {
                val p0 = AxialCoordinate(0, 0)
                val p1 = AxialCoordinate(0, 0)
                assertEquals(0, distance(p0, p1))
            }

            it("works for 0,0 -> 1,0") {
                val p0 = AxialCoordinate(0, 0)
                val p1 = AxialCoordinate(1, 0)
                assertEquals(1, distance(p0, p1))
            }

            it("works for 0,0 -> 1,1") {
                val p0 = AxialCoordinate(0, 0)
                val p1 = AxialCoordinate(1, 1)
                assertEquals(2, distance(p0, p1))
            }

            it("works for 0,0 -> -3,2") {
                val p0 = AxialCoordinate(0,0)
                val p1 = AxialCoordinate(-3, 2)
                assertEquals(3, distance(p0, p1))
            }
        }
    }
})
