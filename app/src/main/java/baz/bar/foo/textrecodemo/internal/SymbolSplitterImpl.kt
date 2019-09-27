package baz.bar.foo.textrecodemo.internal

import baz.bar.foo.textrecodemo.SymbolMatrix
import baz.bar.foo.textrecodemo.SymbolSplitter

class SymbolSplitterImpl : SymbolSplitter {

    override fun split(source: Array<CharArray>): List<SymbolMatrix> {
        return listOf(source)
    }
}