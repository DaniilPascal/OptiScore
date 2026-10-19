package io.github.daniilpascal.optiscore.score

/**
 * Minimal scoring stub for OptiScore development.
 * Replace heuristics with the real analysis pipeline later.
 */
object OptiScoreCalculator {
    fun score(source: String): Int {
        val lines = source.lines()
            .map { it.trim() }
            .filter { it.isNotEmpty() && !it.startsWith("//") && !it.startsWith("#") }

        if (lines.isEmpty()) return 0

        var score = 70
        when {
            lines.size <= 5 -> score += 20
            lines.size <= 15 -> score += 10
            lines.size <= 40 -> score -= 5
            else -> score -= 20
        }

        val nesting = lines.count { it.contains("{") || it.endsWith(":") }
        score -= (nesting - 1).coerceAtLeast(0) * 3

        return score.coerceIn(0, 100)
    }
}
