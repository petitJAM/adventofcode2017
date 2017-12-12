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

fun buildTree(bottomProgram: Program, programs: List<Program>): Node<Program> {
    val allPrograms = programs.filterNot { it == bottomProgram }

    val childPrograms = allPrograms.filter { it.name in bottomProgram.namesOfProgramsAbove }
            .sortedBy {
                bottomProgram.namesOfProgramsAbove.indexOf(it.name)
            }

    val remainingPrograms = allPrograms.filterNot { it in childPrograms }

    val childNodes = childPrograms.map {
        buildTree(it, remainingPrograms)
    }

    return Node(bottomProgram, childNodes)
}

val Node<Program>.totalWeight: Int
    get() = data.weight + childNodes.map { it.totalWeight }.sum()
