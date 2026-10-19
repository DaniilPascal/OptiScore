# OptiScore

IntelliJ Platform plugin that scores code quality / optimization potential inside the IDE.

<!-- Plugin description -->
**OptiScore** analyzes code snippets and shows a 0–100 optimization score in a tool window.

Open **View → Tool Windows → OptiScore**, paste code, press **Score**.
<!-- Plugin description end -->

## Requirements

- JDK / JBR used by Gradle: IntelliJ IDEA bundled JBR (see `org.gradle.java.home` in `gradle.properties`)
- Kotlin JVM toolchain **21** (configured in Gradle)
- Target IDE: IntelliJ IDEA **2025.1+** (`pluginSinceBuild=251`)

## Develop

```bash
./gradlew runIde          # sandbox IDE with the plugin
./gradlew test            # unit tests
./gradlew buildPlugin     # ZIP under build/distributions/
```

IDE run configs are in `.run/` (`Run IDE with Plugin`, `Run Tests`, `Run Verifications`).

### Local IDE (optional)

To run against your installed IDEA instead of a downloaded SDK:

```properties
useLocalIde=true
localIdePath=/Applications/IntelliJ IDEA.app
```

## Layout

```
src/main/kotlin/io/github/daniilpascal/optiscore/
  OptiScoreBundle.kt
  score/OptiScoreCalculator.kt   # scoring logic (start here)
  ui/OptiScoreToolWindowFactory.kt
src/main/resources/META-INF/plugin.xml
src/test/kotlin/...
```

## Useful links

- [IntelliJ Platform SDK](https://plugins.jetbrains.com/docs/intellij)
- [IntelliJ Platform Gradle Plugin](https://plugins.jetbrains.com/docs/intellij/tools-intellij-platform-gradle-plugin.html)
