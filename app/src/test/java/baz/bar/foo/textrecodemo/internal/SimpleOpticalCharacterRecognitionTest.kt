package baz.bar.foo.textrecodemo.internal

import baz.bar.foo.textrecodemo.OpticalCharacterRecognition
import baz.bar.foo.textrecodemo.internal.algorithms.VerticalScanningAlgorithm
import org.junit.Assert.assertEquals
import org.junit.Test

const val A1 =
"""
          *   
         ***  
        ** ** 
       **   **
       **   **
       *******
       *******
       **   **
       **   **
"""

class SimpleOpticalCharacterRecognitionTest {

    private val testee: OpticalCharacterRecognition by lazy {
        val scanningSignatureRecogniser = ScanningSignatureRecogniser(
            calculationSignatureAlgorithm = VerticalScanningAlgorithm()
        )
        SimpleOpticalCharacterRecognition(
            recognisers = listOf(scanningSignatureRecogniser),
            symbolSplitter = SymbolSplitterImpl()
        )
    }

    @Test
    fun testA1() {
        val actual = testee.recogniseText(A1)
        assertEquals("A", actual)
    }

}