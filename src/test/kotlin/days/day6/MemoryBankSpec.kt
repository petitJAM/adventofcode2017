package days.day6

import org.jetbrains.spek.api.Spek
import org.jetbrains.spek.api.dsl.describe
import org.jetbrains.spek.api.dsl.it
import org.junit.platform.runner.JUnitPlatform
import org.junit.runner.RunWith
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

@RunWith(JUnitPlatform::class)
object MemoryBankSpec: Spek({

    describe("valid params") {
        it("throws if an empty initial state is given") {
            assertFailsWith(IllegalArgumentException::class) {
                MemoryBank(listOf())
            }
        }
    }

    describe("currentState") {
        it("returns the initial state if redistribute has not been called") {
            val memoryBank = MemoryBank(1, 2, 3, 4)
            assertEquals(listOf(1, 2, 3, 4), memoryBank.currentState)
        }
    }

    describe("redistribute") {
        it("redistributes the highest block across the other blocks 1") {
            val memoryBank = MemoryBank(0, 2, 7, 0)
            memoryBank.redistribute()
            assertEquals(listOf(2, 4, 1, 2), memoryBank.currentState)
        }

        it("redistributes the highest block across the other blocks 2") {
            val memoryBank = MemoryBank(2, 4, 1, 2)
            memoryBank.redistribute()
            assertEquals(listOf(3, 1, 2, 3), memoryBank.currentState)
        }

        it("redistributes the highest block across the other blocks 3") {
            val memoryBank = MemoryBank(3, 1, 2, 3)
            memoryBank.redistribute()
            assertEquals(listOf(0, 2, 3, 4), memoryBank.currentState)
        }

        it("redistributes the highest block across the other blocks 4") {
            val memoryBank = MemoryBank(0, 2, 3, 4)
            memoryBank.redistribute()
            assertEquals(listOf(1, 3, 4, 1), memoryBank.currentState)
        }

        it("redistributes the highest block across the other blocks 5") {
            val memoryBank = MemoryBank(1, 3, 4, 1)
            memoryBank.redistribute()
            assertEquals(listOf(2, 4, 1, 2), memoryBank.currentState)
        }
    }
})