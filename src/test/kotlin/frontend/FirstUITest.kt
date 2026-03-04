package frontend

import com.codeborne.selenide.Selenide
import org.example.frontend.helpers.BaseUITest
import org.junit.jupiter.api.Disabled
import org.junit.jupiter.api.Test

class FirstUITest : BaseUITest() {

    @Test
    @Disabled("Jast for demonstartion purposes")
    fun testFirstUI() {
        val searchInput = Selenide.element("[name='q']")
        searchInput.value = "Selenide"
        searchInput.pressEnter()
        Selenide.sleep(5000)
    }

}