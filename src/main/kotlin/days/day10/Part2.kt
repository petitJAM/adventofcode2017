package days.day10

object Part2 {

    private val salt = listOf(17, 31, 73, 47, 23)

    fun solve(puzzleInput: String): String {
        val lengths = saltedLengths(puzzleInput)

        var currentPosition = 0
        var skipSize = 0
        var sparseHash = (0..255).toList()

        for (i in (1..64)) {
            val result = doNextKnot(sparseHash, lengths, currentPosition, skipSize)
            sparseHash = result.hash
            currentPosition = result.position
            skipSize = result.skipSize
        }

        val blockedHash = splitToBlocks(sparseHash, 16)

        val denseHash = blockedHash.map { block ->
            block.reduceRight { i: Int, acc: Int ->
                i.xor(acc)
            }
        }

        return denseHash.joinToString("") { it.toString(16).padStart(2, '0') }
    }

    fun saltedLengths(input: String): List<Int> {
        return input.toCharArray().map(Char::toByte).map(Byte::toInt) + salt
    }

    fun splitToBlocks(input: List<Int>, blockSize: Int): List<List<Int>> {
        return input
                .withIndex()
                .groupBy { it.index / blockSize }
                .values
                .map { block: List<IndexedValue<Int>> ->
                    block.map { it.value }
                }
    }

    private tailrec fun doNextKnot(circularList: List<Int>, remainingInputs: List<Int>, currentPosition: Int, skipSize: Int): Result {
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

        val nextPosition = (currentPosition + currentInput + skipSize) % circularList.size
        val nextSkipSize = skipSize + 1

        return if (remainingInputs.size == 1) {
            Result(knottedList, nextPosition, nextSkipSize)
        } else {
            doNextKnot(knottedList, remainingInputs.drop(1), nextPosition, nextSkipSize)
        }
    }

    private data class Result(val hash: List<Int>, val position: Int, val skipSize: Int)
}
