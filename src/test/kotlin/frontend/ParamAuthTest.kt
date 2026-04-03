package frontend

import com.codeborne.selenide.Selenide.element
import io.kotest.matchers.shouldBe
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.helpers.Wrappers.Companion.byTestId
import org.example.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class ParamAuthTest : BaseUITest() {

    @ParameterizedTest
    @CsvSource(
        value = [
            "' ', Username",
            "' ', Password",
            "' ', Please enter username, email and password"
        ]
    )
    @DisplayName("Проверка валидации: логин/пароль/ошибка - {0}/{1}/{2}")
    fun testLoginValidation(login: String, password: String, error: String) {
        MainPage()
            .navigateHeader()
            .clickLink("Join")
        element(byTestId("UserName")).setValue(login)
        element(byTestId("Password")).setValue(password)
        element(byTestId("active-btn")).click()

        element(byTestId("create-error")).text shouldBe error
    }
}