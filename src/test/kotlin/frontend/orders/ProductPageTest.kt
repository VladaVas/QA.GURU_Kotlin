package frontend.orders

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
    // Падает с ошибкой expected:<Coca Cola>
    // but was:<[[data-test-group="product-card-name"].snapshot(6 elements)[0],
    // [data-test-group="product-card-name"].snapshot(6 elements)[1], [
    // data-test-group="product-card-name"].snapshot(6 elements)[2],
    // [data-test-group="product-card-name"].snapshot(6 elements)[3],
    // [data-test-group="product-card-name"].snapshot(6 elements)[4],
    // [data-test-group="product-card-name"].snapshot(6 elements)[5]]>
    fun cardName() {
        MainPage()
            .navigateHeader()
            .clickLink("Products")
        val cardsName = ProductsPage()
            .getCardName()

        val cardDescription = ProductsPage()
            .getCardName()

        cardsName shouldBe "Coca Cola"
        cardDescription shouldBe "A wonderful coca cola for your daily brew."
    }
}