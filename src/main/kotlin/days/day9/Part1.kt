package days.day9

import util.NotSolvableError

object Part1 {

    fun solve(puzzleInput: String): Int {

        val chars = puzzleInput.toCharArray()
        var lookingAt = 1 // assumes first char is {

        var inGarbage = false

        val firstGroup = Group()
        var currentGroup: Group? = firstGroup

        while (lookingAt < chars.size) {

            val char = chars[lookingAt]

            when (char) {
                '{' -> {
                    // open a new group
                    if (!inGarbage) {
                        if (currentGroup?.closed == false) {
                            val newGroup = Group(currentGroup)
                            currentGroup.subgroups += newGroup
                            currentGroup = newGroup
                        } else {
                            NotSolvableError("Something is bad. I don't think this can happen?")
                        }
                    }
                }
                '}' -> {
                    // close the most recent group
                    if (!inGarbage) {
                        currentGroup?.closed = true
                        currentGroup = currentGroup?.parent
                    }
                }
                '<' -> {
                    // open garbage unless garbage is open
                    inGarbage = true
                }
                '>' -> {
                    // close garbage if open
                    inGarbage = false
                }
                '!' -> {
                    // skip next index
                    lookingAt += 1
                }
                else -> {
                    // ignore if garbage is open
                    // ignore if last group close and is comma
                    // so just ignore lol
                }
            }

            lookingAt += 1
        }

        return firstGroup.score()
    }
}
