package days.day12

object Part2 {

    fun solve(puzzleInput: Map<Int, List<Int>>): Int {
        return doIt(puzzleInput, emptyList(), puzzleInput.keys.toList()).size
    }

    private tailrec fun doIt(allPrograms: Map<Int, List<Int>>, groups: List<List<Int>>, programsToAdd: List<Int>): List<List<Int>> {
        return if (programsToAdd.isEmpty()) {
            groups
        } else {
            val program = programsToAdd.first()
            val neighbors = allPrograms[program] ?: emptyList()
            val (groupsContaining, others) = groups.partition { group ->
                neighbors.any { it in group }
            }
            val newGroup = groupsContaining.flatMap { it } + program
            doIt(allPrograms, others + listOf(newGroup), programsToAdd.drop(1))
        }
    }
}
