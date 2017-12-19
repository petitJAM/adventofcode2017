package days.day11

@Throws(IllegalArgumentException::class)
fun directionToHexCoordinate(direction: String): AxialCoordinate {
    return when (direction) {
        "n" -> AxialCoordinate(0, -1)
        "nw" -> AxialCoordinate(-1, 0)
        "ne" -> AxialCoordinate(1, -1)
        "s" -> AxialCoordinate(0, 1)
        "sw" -> AxialCoordinate(-1, 1)
        "se" -> AxialCoordinate(1, 0)
        else -> throw IllegalArgumentException("Unexpected Input")
    }
}

fun distance(a: AxialCoordinate, b: AxialCoordinate): Int {
    return distance(axialToCube(a), axialToCube(b))
}

fun distance(a: CubeCoordinate, b: CubeCoordinate): Int {
    return (Math.abs(a.x - b.x) + Math.abs(a.y - b.y) + Math.abs(a.z - b.z)) / 2
}

fun axialToCube(c: AxialCoordinate): CubeCoordinate {
    val x = c.q
    val z = c.r
    val y = -x - z
    return CubeCoordinate(x, y, z)
}