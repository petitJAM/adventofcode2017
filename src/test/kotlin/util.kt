fun Int.times(action: () -> Unit) {
    (1..this).forEach { action() }
}