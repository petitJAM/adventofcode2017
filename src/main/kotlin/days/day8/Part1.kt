package days.day8

import util.NotSolvableError
import util.head
import util.tail

object Part1 {

    fun solve(puzzleInput: List<Instruction>): Int {
        return findLargestRegisterValueAfterNextInstruction(puzzleInput, mapOf())
    }

    private tailrec fun findLargestRegisterValueAfterNextInstruction(instructions: List<Instruction>, registers: Map<String, Int>): Int {
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

        return if (instructions.tail.isEmpty()) {
            updatedRegisters.values.max() ?: throw NotSolvableError("Bad input")
        } else {
            findLargestRegisterValueAfterNextInstruction(instructions.tail, updatedRegisters)
        }
    }
}
