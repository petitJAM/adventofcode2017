package days.day12

object Part1 {

    fun solve(puzzleInput: Map<Int, List<Int>>): Int {

        return addNeighbors(puzzleInput, listOf(0)).size
    }

    tailrec fun addNeighbors(allPrograms: Map<Int, List<Int>>, group: List<Int>): List<Int> {
        val programsToAdd = group.flatMap { allPrograms[it] ?: emptyList() }.distinct()
        val newGroup = (group + programsToAdd).distinct()
        return if (newGroup == group) {
            group
        } else {
            addNeighbors(allPrograms, newGroup)
        }
    }
}
