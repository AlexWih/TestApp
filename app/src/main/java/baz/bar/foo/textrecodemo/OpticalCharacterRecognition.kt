package baz.bar.foo.textrecodemo

typealias SymbolMatrix = Array<IntArray>

interface OpticalCharacterRecognition {
    fun recogniseText(source: String): String
}


/*sealed class RecognitionResult {
    data class FullSuccess(
        val char: Char
    )
}*/
interface SymbolRecogniser {
    fun recognise(source: Array<IntArray>): List<Char> // may be return possibility as well?
}

interface SymbolSplitter {
    fun split(source: Array<IntArray>): List<SymbolMatrix>
}

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

    private fun prepareSourceArray(source: String): Array<IntArray> {

    }


    // returns the most probable character!
    private fun recogniseSymbol(symbolMatrix: SymbolMatrix): Char? {

    }

}

class Goo2 {

    private val bla = Array(10) { IntArray(10) }

    private fun bla(bla: Array<IntArray>) {

    }
}