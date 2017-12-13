package days.day8

import util.NotSolvableError
import util.head
import util.tail

object Part2 {

    fun solve(puzzleInput: List<Instruction>): Int {
        return findLargestRegisterValueAfterNextInstruction(puzzleInput, mapOf(), Int.MIN_VALUE)
    }

    private tailrec fun findLargestRegisterValueAfterNextInstruction(instructions: List<Instruction>, registers: Map<String, Int>, maxEver: Int): Int {
        val currentInstruction = instructions.head
        val updatedRegisters = if (currentInstruction.condition.evaluate(registers)) {
            val currentRegValue = registers.getOrDefault(currentInstruction.register, 0)
            val newRegValue = when(currentInstruction.operation) {
                Operation.Inc -> currentRegValue + currentInstruction.amount
                Operation.Dec -> currentRegValue - currentInstruction.amount
            }
            registers + mapOf(currentInstruction.register to newRegValue)
        } else {
            registers
        }

        val currentMax = updatedRegisters.values.max() ?: 0
        val newMax = Math.max(maxEver, currentMax)

        return if (instructions.tail.isEmpty()) {
            newMax
        } else {
            findLargestRegisterValueAfterNextInstruction(instructions.tail, updatedRegisters, newMax)
        }
    }
}
