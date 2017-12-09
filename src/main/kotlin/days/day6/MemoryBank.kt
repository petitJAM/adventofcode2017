package days.day6

class MemoryBank(vararg initialState: Int) {

    constructor(initialState: List<Int>) : this(*initialState.toIntArray())

    private var mutableState = initialState.toList()

    init {
        require(initialState.isNotEmpty()) { "initialState cannot be empty" }
    }

    val currentState: List<Int>
        get() = mutableState

    fun redistribute() {
        val max = mutableState.max()
        val indexToDistribute = mutableState.indexOfFirst { it == max }
        val amountToRedistribute = mutableState[indexToDistribute]

        val mutableCopy = mutableState.toMutableList()

        mutableCopy[indexToDistribute] = 0

        var remaining = amountToRedistribute
        var idx = (indexToDistribute + 1) % mutableState.size

        while (remaining > 0) {
            mutableCopy[idx] += 1
            idx = (idx + 1) % mutableState.size
            remaining -= 1
        }

        mutableState = mutableCopy
    }
}