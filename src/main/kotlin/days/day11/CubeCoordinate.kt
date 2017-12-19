package days.day11

data class CubeCoordinate(val x: Int, val y: Int, val z: Int) {
    init {
        if (x + y + z != 0) {
            throw IllegalArgumentException("Cube coordinate components must sum to 0")
        }
    }
}