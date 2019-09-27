package baz.bar.foo.textrecodemo

interface SymbolRecogniser {
    fun recognise(source: SymbolMatrix): List<Char>
}