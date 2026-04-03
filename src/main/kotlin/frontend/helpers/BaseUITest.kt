package org.example.frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


open class BaseUITest {

    init {
        Configuration.browser = DriverProvider::class.java.name
    }

    @BeforeEach
    fun openBrowser() {
        Selenide.open("/")
    }

    @AfterEach
    fun closeBrowser() {
        Selenide.clearBrowserCookies()
        Selenide.clearBrowserLocalStorage()
    }
}