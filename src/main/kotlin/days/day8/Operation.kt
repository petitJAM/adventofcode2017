package days.day8

sealed class Operation {
    object Inc : Operation()
    object Dec : Operation()

    companion object {
        fun from(str: String): Operation {
            return when (str) {
                "inc" -> Inc
                "dec" -> Dec
                else -> throw IllegalArgumentException("Unknown operation: $str")
            }
        }
    }
}