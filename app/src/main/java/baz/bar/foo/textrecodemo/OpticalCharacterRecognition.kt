package baz.bar.foo.textrecodemo

typealias SymbolMatrix = Array<CharArray> // asterixes and whitespaces for now.

typealias WhiteSpaceRecogniser = (Char) -> Boolean // returns true if it is a whitespace

interface OpticalCharacterRecognition {
    fun recogniseText(source: String): String
}
