package frontend

import org.example.kotlin.general.Config
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.extension.ExtensionContext
import org.junit.jupiter.api.extension.TestWatcher
import kotlin.annotation.AnnotationRetention
import kotlin.annotation.AnnotationTarget
import kotlin.annotation.Retention
import kotlin.annotation.Target

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@ExtendWith(PropTestConfigWatcher::class)
annotation class WithPropTestConfigWatcher

class PropTestConfigWatcher : TestWatcher {

    override fun testSuccessful(context: ExtensionContext) {
        println("PropTest OK: ${context.displayName}")
    }

    override fun testFailed(context: ExtensionContext, cause: Throwable?) {
        println("PropTest FAIL: ${context.displayName} — ${cause?.message}")
    }
}

@WithPropTestConfigWatcher
class PropTest {

    @Test
    fun configFrontendUrlIsReachableScheme() {
        assertTrue(Config.get.frontendUrl.startsWith("http"))
    }
}
