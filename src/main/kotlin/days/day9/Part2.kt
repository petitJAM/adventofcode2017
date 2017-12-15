package days.day9

import util.NotSolvableError

object Part2 {

    fun solve(puzzleInput: String): Int {
        val chars = puzzleInput.toCharArray()
        var lookingAt = 1 // assumes first char is {

        var inGarbage = false

        val firstGroup = Group()
        var currentGroup: Group? = firstGroup

        var garbageCounter = 0

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
                    } else {
                        garbageCounter += 1
                    }
                }
                '}' -> {
                    // close the most recent group
                    if (!inGarbage) {
                        currentGroup?.closed = true
                        currentGroup = currentGroup?.parent
                    } else {
                        garbageCounter += 1
                    }
                }
                '<' -> {
                    // open garbage unless garbage is open
                    if (!inGarbage) {
                        inGarbage = true
                    } else {
                        garbageCounter += 1
                    }
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
                    if (inGarbage) {
                        garbageCounter += 1
                    }
                }
            }

            lookingAt += 1
        }

        return garbageCounter
    }
}
