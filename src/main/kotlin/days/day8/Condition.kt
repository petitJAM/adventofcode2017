package days.day8

data class Condition(val register: String,
                     val comparison: Comparison,
                     val compareTo: Int) {

    fun evaluate(registers: Map<String, Int>): Boolean {
        return comparison.compare(
                registers.getOrDefault(register, 0),
                compareTo)
    }
}