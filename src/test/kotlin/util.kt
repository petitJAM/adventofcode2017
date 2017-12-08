fun Int.times(action: (i: Int) -> Unit) {
    (1..this).forEach { action(it) }
}