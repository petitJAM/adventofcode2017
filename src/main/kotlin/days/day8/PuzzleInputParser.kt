package days.day8

object PuzzleInputParser {

    fun parse(puzzleInput: String): List<Instruction> {
        return puzzleInput.split("\n")
                .filterNot { it.isBlank() }
                .map { line ->
                    if (line.split(" if ").size < 2) {
                        println()
                    }
                    val (instructionStr, conditionStr) = line.split(" if ")
                    val (register, operationStr, amount) = instructionStr.split(" ")
                    val (comparedRegister, comparisonStr, compareToStr) = conditionStr.split(" ")
                    Instruction(
                            register,
                            Operation.from(operationStr),
                            amount.toInt(),
                            Condition(comparedRegister, Comparison.from(comparisonStr), compareToStr.toInt()))
                }
    }
}
