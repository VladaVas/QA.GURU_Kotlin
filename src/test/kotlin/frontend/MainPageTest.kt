package frontend

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.sleep
import io.kotest.matchers.shouldBe
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.ContactPage
import org.example.frontend.pages.MainPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class MainPageTest : BaseUITest() {

    @Test
    @DisplayName("Проверка названия кофейни на главной странице")
    fun welcomeMessage() {
        val title = MainPage()
            .getTitle()

        title shouldBe "Welcome to Brew & Bean"
    }

    @Test
    @DisplayName("Проверка корректности наименований ссылок в шапке")
    fun navLinksName() {
       val navLinks = MainPage()
            .navigateHeader()
            .getLinksName()

        navLinks shouldBe listOf("Brew & Bean", "Products", "Orders", "Contact", "Cart", "Join")
    }

//    @Test
//    @DisplayName("Проверка навигации по ссылке \"Products\" в шапке")
//    fun clickProductsLink() {
//        MainPage()
//            .navigateHeader()
//            .clickLink("Products")
//        val products = ProductsPage()
//            .getProducts()
//
//        products.shouldHaveSize(6)
//    }

    @Test
    @DisplayName("Проверка навигации по ссылке \"Contact\" в шапке")
    fun clickContactLink() {
        MainPage()
            .navigateHeader()
            .clickLink("Contact")
        val contact = ContactPage()
            .getContactTitle()

        contact shouldBe "Testing Playground Frontend"
    }

//    @Test
//    fun openGoogleTest() {
//        val title = Selenide.title()
//        sleep(15000)
//
//        title shouldBe "Google"
//    }
}