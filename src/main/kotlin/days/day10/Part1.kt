package days.day10

object Part1 {

    fun solve(puzzleInput: List<Int>, circularListLength: Int): Int {
        val knottedList = doNextKnot((0 until circularListLength).toList(), puzzleInput, 0, 0)
        return knottedList[0] * knottedList[1]
    }

    tailrec fun doNextKnot(circularList: List<Int>, remainingInputs: List<Int>, currentPosition: Int, skipSize: Int): List<Int> {
        val currentInput = remainingInputs.first()

        val sublistFrom = currentPosition
        val sublistTo = currentPosition + currentInput
        val overflow = sublistTo - circularList.size

        val knottedList: List<Int> = when {
            overflow == 0 && sublistFrom == 0 -> {
                circularList.reversed()
            }
            overflow > 0 -> { // sublistTo >= circularList.size
                val atTheEnd = circularList.size - currentPosition
                val subListReversed = (circularList.takeLast(atTheEnd) +
                                circularList.take(overflow))
                        .reversed()

                val front = subListReversed.takeLast(overflow)
                val middle = circularList.subList(overflow, currentPosition)
                val end = subListReversed.subList(0, subListReversed.lastIndex + 1 - overflow)
                front + middle + end
            }
            else -> { // overflow < 0
                val front = circularList.subList(0, currentPosition)
                val middle = circularList.subList(sublistFrom, sublistTo).reversed()
                val end = circularList.subList(sublistTo, circularList.lastIndex + 1)
                front + middle + end
            }
        }

        return if (remainingInputs.size == 1) {
            knottedList
        } else {
            doNextKnot(knottedList, remainingInputs.drop(1), (currentPosition + currentInput + skipSize) % circularList.size, skipSize + 1)
        }
    }
}
