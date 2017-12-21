package days.day13

object Part2 {

    fun solve(puzzleInput: Map<Int, Int>): Int {
        var delay = 0
        while (true) {
            val severity = calculateTimesCaught(puzzleInput, delay)
            if (severity == 0) break
            delay += 1
        }
        return delay
    }
}
