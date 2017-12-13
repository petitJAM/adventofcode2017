package days.day8

sealed class Comparison {
    abstract fun compare(left: Int, right: Int): Boolean

    object LessThan : Comparison() {
        override fun compare(left: Int, right: Int) = left < right
    }

    object LessThanOrEqualTo : Comparison() {
        override fun compare(left: Int, right: Int) = left <= right
    }

    object EqualTo : Comparison() {
        override fun compare(left: Int, right: Int) = left == right
    }

    object NotEqualTo : Comparison() {
        override fun compare(left: Int, right: Int) = left != right
    }

    object GreaterThan : Comparison() {
        override fun compare(left: Int, right: Int) = left > right
    }

    object GreaterThanOrEqualTo : Comparison() {
        override fun compare(left: Int, right: Int) = left >= right
    }

    companion object {
        fun from(str: String): Comparison {
            return when (str) {
                "<" -> LessThan
                "<=" -> LessThanOrEqualTo
                "==" -> EqualTo
                "!=" -> NotEqualTo
                ">" -> GreaterThan
                ">=" -> GreaterThanOrEqualTo
                else -> throw IllegalArgumentException("Unknown comparison: $str")
            }
        }
    }
}