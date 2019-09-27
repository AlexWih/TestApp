package baz.bar.foo.textrecodemo.internal

import baz.bar.foo.textrecodemo.SymbolMatrix
import baz.bar.foo.textrecodemo.SymbolRecogniser

typealias CalculationSignatureAlgorithm = (SymbolMatrix) -> String

class ScanningSignatureRecogniser(
    private val signatureRegistry: Map<String, List<Char>> = mapOf(
        Pair("", listOf('a'))
    ),
    private val calculationSignatureAlgorithm: CalculationSignatureAlgorithm
) : SymbolRecogniser {
    override fun recognise(source: SymbolMatrix): List<Char> {
        val signature = calculationSignatureAlgorithm(source)
        return signatureRegistry[signature] ?: emptyList()
    }
}