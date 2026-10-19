package io.github.daniilpascal.optiscore.score

import org.junit.Assert.assertEquals
import org.junit.Assert.assertTrue
import org.junit.Test

class OptiScoreCalculatorTest {
    @Test
    fun `empty source scores zero`() {
        assertEquals(0, OptiScoreCalculator.score(""))
        assertEquals(0, OptiScoreCalculator.score("   \n  // comment"))
    }

    @Test
    fun `short function scores high`() {
        val score = OptiScoreCalculator.score(
            """
            fun example() {
                println("hello")
            }
            """.trimIndent(),
        )
        assertTrue(score in 80..100)
    }
}
