package frontend.orders

import io.kotest.matchers.shouldBe
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.ContactPage
import org.example.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ContatctPageTest: BaseUITest() {
    @Test
    @DisplayName("Проверка описания контакта")
    fun contactDescription() {
        MainPage()
            .navigateHeader()
            .clickLink("Contact")
        val contactDescription = ContactPage()
            .getContactDescription()

        contactDescription shouldBe """
            Welcome to a dedicated website for practicing automated UI testing.
            This app is designed to work together with testing-playground-backend.
            Happy testing!
        """.trimIndent()
    }
}