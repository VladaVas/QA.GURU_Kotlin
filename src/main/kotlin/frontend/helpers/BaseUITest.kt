package org.example.frontend.helpers

import com.codeborne.selenide.Configuration
import com.codeborne.selenide.Selenide
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.BeforeEach


open class BaseUITest {

    init {
        Configuration.timeout = 15000
        Configuration.pageLoadStrategy = "normal"
        Configuration.reopenBrowserOnFail = true
        Configuration.baseUrl = "http://localhost:4000"
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