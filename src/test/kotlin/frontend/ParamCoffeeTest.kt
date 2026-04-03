package frontend


import io.kotest.matchers.collections.shouldContain
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

class ParamCoffeeTest: BaseUITest() {

    @ParameterizedTest
    @ValueSource(strings = ["Products", "Orders", "Contact", "Cart"])
    @DisplayName("Проверка наличия ссылок в шапке: {link}")
    fun testWithValueSource(link: String) {
        val listLinks = MainPage().navigateHeader().getLinksName()

        listLinks shouldContain link
    }
}