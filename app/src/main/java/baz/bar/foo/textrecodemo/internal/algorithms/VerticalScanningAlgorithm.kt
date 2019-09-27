package baz.bar.foo.textrecodemo.internal.algorithms

import baz.bar.foo.textrecodemo.SymbolMatrix
import baz.bar.foo.textrecodemo.WhiteSpaceRecogniser
import baz.bar.foo.textrecodemo.internal.CalculationSignatureAlgorithm

class VerticalScanningAlgorithm(
    private val whiteSpaceRecogniser: WhiteSpaceRecogniser = { it.isWhitespace() }
) : CalculationSignatureAlgorithm {
    override fun invoke(symbolMatrix: SymbolMatrix): String {
        val rowCount = symbolMatrix[0].size //may lead to Index Our of bound exc!
        val signatures = LinkedHashSet<String>()
        for (row in 0 until rowCount) {
            val list = mutableListOf<Boolean>()
            for (i in symbolMatrix.indices) {
                val isWhiteSpace = whiteSpaceRecogniser.invoke(symbolMatrix[i][row])
                list.add(isWhiteSpace)
            }
            val rowSignature = calculateRowSignature(list)
            signatures.add(rowSignature)
        }
        return signatures.toCollection(mutableListOf()).joinToString(
            separator = ""
        )
    }

    private fun calculateRowSignature(column: List<Boolean>): String {
        val firstCharIndex = column.indexOfFirst {
            false
        }
        var isPreviousWhiteSpace = false
        var counter = 1
        for (pixel in firstCharIndex + 1 until column.size - 1) {
            val isWhiteSpace = column[pixel]
            if (isWhiteSpace.not() && isPreviousWhiteSpace) {
                counter++
            }
            isPreviousWhiteSpace = isWhiteSpace
        }
        return counter.toString()
    }

}