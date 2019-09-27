package baz.bar.foo.textrecodemo.internal

import baz.bar.foo.textrecodemo.SymbolMatrix
import baz.bar.foo.textrecodemo.SymbolRecogniser

typealias CalculationSignatureAlgorithm = (SymbolMatrix) -> Int

class ScanningSignatureRecogniser(
    private val signatureRegistry: Map<Int, List<Char>>, //not good as algorithm is specified separately from registry!
    private val calculationSignatureAlgorithm: CalculationSignatureAlgorithm
) : SymbolRecogniser {
    override fun recognise(source: SymbolMatrix): List<Char> {
        val signature = calculationSignatureAlgorithm(source)
        return signatureRegistry[signature] ?: emptyList()
    }
}