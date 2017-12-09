package days.day7

data class Program(val name: String,
                   val weight: Int,
                   val namesOfProgramsAbove: List<String> = emptyList())