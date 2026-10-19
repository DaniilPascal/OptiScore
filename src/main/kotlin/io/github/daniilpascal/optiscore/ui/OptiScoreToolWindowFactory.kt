package io.github.daniilpascal.optiscore.ui

import com.intellij.openapi.project.Project
import com.intellij.openapi.wm.ToolWindow
import com.intellij.openapi.wm.ToolWindowFactory
import com.intellij.ui.components.JBLabel
import com.intellij.ui.components.JBPanel
import com.intellij.ui.content.ContentFactory
import io.github.daniilpascal.optiscore.OptiScoreBundle
import io.github.daniilpascal.optiscore.score.OptiScoreCalculator
import javax.swing.JButton
import javax.swing.JTextArea

class OptiScoreToolWindowFactory : ToolWindowFactory {
    override fun shouldBeAvailable(project: Project) = true

    override fun createToolWindowContent(project: Project, toolWindow: ToolWindow) {
        val panel = OptiScorePanel()
        val content = ContentFactory.getInstance().createContent(panel.getContent(), null, false)
        toolWindow.contentManager.addContent(content)
    }

    private class OptiScorePanel {
        private val input = JTextArea(8, 40).apply {
            text = "fun example() {\n    println(\"hello\")\n}"
            lineWrap = true
        }
        private val result = JBLabel(OptiScoreBundle.message("toolwindow.result.label", "—"))

        private val content = JBPanel<JBPanel<*>>().apply {
            add(input)
            add(JButton(OptiScoreBundle.message("toolwindow.score.button")).apply {
                addActionListener {
                    val score = OptiScoreCalculator.score(input.text)
                    result.text = OptiScoreBundle.message("toolwindow.result.label", score)
                }
            })
            add(result)
        }

        fun getContent(): JBPanel<JBPanel<*>> = content
    }
}
