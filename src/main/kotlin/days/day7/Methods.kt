package days.day7

fun findBottomProgram(programs: List<Program>): Program? {
    val nameCounts = mutableMapOf<String, Int>().withDefault { 0 }
    programs.forEach { program ->
        program.namesOfProgramsAbove.forEach { name ->
            val count = nameCounts.getValue(name)
            nameCounts[name] = count + 1
        }
    }
    return programs.find { nameCounts.getValue(it.name) == 0 }
}