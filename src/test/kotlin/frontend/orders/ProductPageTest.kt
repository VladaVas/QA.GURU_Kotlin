package frontend.orders

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.shouldBe
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.MainPage
import org.example.frontend.pages.ProductsPage
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ProductPageTest : BaseUITest() {
    @Test
    @DisplayName("Проверка заголовка на странице \"Products\"")
    fun productsLTitle() {
        MainPage()
            .navigateHeader()
            .clickLink("Products")
        val productsTitle = ProductsPage()
            .getTitle()

        productsTitle shouldBe "All Products"
    }

    @Test
    @DisplayName("Проверить название и описание карточки продукта")
    fun cardName() {
        MainPage()
            .navigateHeader()
            .clickLink("Products")
        val cardNames = ProductsPage()
            .getAllCardNames()

        cardNames shouldContain "Coca Cola"
    }

    @Test
    @DisplayName("Проверить название и описание карточки продукта")
    fun cardDescription() {
        MainPage()
            .navigateHeader()
            .clickLink("Products")
        val cardDescription = ProductsPage()
            .getCardDescription()

        cardDescription shouldContain "A wonderful coca cola for your daily brew."
    }
}