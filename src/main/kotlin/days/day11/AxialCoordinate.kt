package days.day11

data class AxialCoordinate(val q: Int, val r: Int) {

    companion object {
        val ORIGIN = AxialCoordinate(0, 0)
    }

    operator fun plus(other: AxialCoordinate): AxialCoordinate {
        return AxialCoordinate(q + other.q, r + other.r)
    }
}