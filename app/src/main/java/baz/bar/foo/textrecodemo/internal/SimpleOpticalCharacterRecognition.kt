package baz.bar.foo.textrecodemo.internal

import baz.bar.foo.textrecodemo.OpticalCharacterRecognition
import baz.bar.foo.textrecodemo.SymbolMatrix
import baz.bar.foo.textrecodemo.SymbolRecogniser
import baz.bar.foo.textrecodemo.SymbolSplitter

class SimpleOpticalCharacterRecognition(
    private val recognisers: List<SymbolRecogniser>,
    private val symbolSplitter: SymbolSplitter
) : OpticalCharacterRecognition {

    override fun recogniseText(source: String): String {
        if (source.isBlank()) {
            return ""
        }
        val stringMatrix = prepareSourceArray(source)
        val symbols = symbolSplitter.split(stringMatrix)
        return symbols.map {
            recogniseSymbol(it)
        }.joinToString(separator = "") {
            (it ?: '?').toString() //not optimal from memory perspective, to be improved later.
        }
    }

    private fun prepareSourceArray(source: String): Array<CharArray> {
        val rows = source.split("\n")
        return Array(rows.size) {
            rows[it].toCharArray()
        }
    }

    // returns the most probable character!
    private fun recogniseSymbol(symbolMatrix: SymbolMatrix): Char? {
        val matchCounters = mutableMapOf<Char, Int>()
        for (recogniser in recognisers) {
            val recognitionResults = recogniser.recognise(symbolMatrix)
            if (recognitionResults.size == 1) {
                //100% match
                return recognitionResults[0]
            }
            for (symbol in recognitionResults) {
                var counter = matchCounters[symbol] ?: 0
                matchCounters[symbol] = ++counter

            }
        }
        return matchCounters.maxWith(Comparator { entry: Map.Entry<Char, Int>, entry1: Map.Entry<Char, Int> ->
            entry.value - entry1.value
        })?.key
    }

}
