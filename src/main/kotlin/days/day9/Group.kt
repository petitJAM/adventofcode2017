package days.day9

class Group(val parent: Group? = null) {

    var closed = false

    val subgroups: MutableList<Group> = mutableListOf()

    fun score(): Int {
        return scoreOfChildren(1)
    }

    private fun scoreOfChildren(parentScore: Int): Int {
        return subgroups.map { it.scoreOfChildren(parentScore + 1) }.sum() + parentScore
    }
}