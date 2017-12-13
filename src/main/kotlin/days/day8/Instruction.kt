package days.day8

data class Instruction(val register: String,
                       val operation: Operation,
                       val amount: Int,
                       val condition: Condition)