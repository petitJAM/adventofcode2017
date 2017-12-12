package days.day7

data class Node<T>(val data: T,
                   val childNodes: List<Node<T>> = emptyList())