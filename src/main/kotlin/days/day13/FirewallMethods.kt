package days.day13

fun calculateTripSeverity(firewall: Map<Int, Int>): Int {
    return firewall.keys.map { depth ->
        val scannerRange = firewall.getValue(depth)
        if (depth % ((scannerRange - 1) * 2) == 0) {
            depth * scannerRange
        } else {
            0
        }
    }.sum()
}

fun calculateTimesCaught(firewall: Map<Int, Int>, delay: Int): Int {
    return firewall.keys.map { depth ->
        val scannerRange = firewall.getValue(depth)
        (depth + delay) % ((scannerRange - 1) * 2) == 0
    }.count { it }
}