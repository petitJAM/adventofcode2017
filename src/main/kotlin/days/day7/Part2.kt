package days.day7

import util.NotSolvableError

object Part2 {

    fun solve(puzzleInput: List<Program>): Int {
        val bottomProgram = findBottomProgram(puzzleInput)
                ?: throw NotSolvableError("No bottom program found")

        val tree = buildTree(bottomProgram, puzzleInput)

        return findUnbalancedNode(tree, bottomProgram.weight, 0)
    }

    tailrec fun findUnbalancedNode(node: Node<Program>, previousBalancedWeight: Int, previousUnbalancedWeight: Int): Int {

        val weightsToChildNodes = mutableMapOf<Int, List<Node<Program>>>().withDefault { listOf() }

        node.childNodes.forEach { child ->
            weightsToChildNodes[child.totalWeight] = weightsToChildNodes.getValue(child.totalWeight).plus(child)
        }

        return if (weightsToChildNodes.size == 1) {
            return node.data.weight - Math.abs(previousBalancedWeight - previousUnbalancedWeight)

        } else {
            val nodeWithDifferentWeight = weightsToChildNodes.values.first { it.size == 1 }.first()
            val balancedWeight = weightsToChildNodes.keys.first { weightsToChildNodes.getValue(it).size != 1 }
            val unbalancedWeight = nodeWithDifferentWeight.totalWeight
            findUnbalancedNode(nodeWithDifferentWeight, balancedWeight, unbalancedWeight)
        }
    }
}
