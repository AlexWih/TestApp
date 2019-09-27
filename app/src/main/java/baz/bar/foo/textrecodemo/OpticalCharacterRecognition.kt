package baz.bar.foo.textrecodemo

typealias SymbolMatrix = Array<CharArray> // asterixes and whitespaces for now.

interface OpticalCharacterRecognition {
    fun recogniseText(source: String): String
}
