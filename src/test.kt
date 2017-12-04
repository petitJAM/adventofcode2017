fun expect(code: () -> Any): ExpectationBuilder {
    return ExpectationBuilder(code)
}

class ExpectationBuilder(private val code: () -> Any) {
    fun toEqual(expected: Any) {
        val result = code()
        if (result == expected) {
            println("Passed")
        } else {
            throw TestFailedError(expected, result)
        }
    }
}

class TestFailedError(expected: Any, actual: Any)
    : Error("Expected $expected, was $actual")