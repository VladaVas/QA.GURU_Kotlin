package frontend.orders

import io.kotest.matchers.collections.shouldContain
import io.kotest.matchers.equality.shouldBeEqualToDifferentTypeIgnoringFields
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.example.frontend.components.list.ProductItem
import org.example.frontend.helpers.BaseUITest
import org.example.frontend.pages.MainPage
import org.example.frontend.pages.ProductsPage
import org.junit.jupiter.api.Assertions.fail
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

    @Test
    @DisplayName("Первый популярный продукт совпадает с первым продуктом на странице Products")
    fun firstPopularMatchesFirstProduct() {
        val firstPopularItem = MainPage().getFirstPopularProduct()

        MainPage().navigateHeader().clickLink("Products")

        val firstProductItem = ProductsPage().getFirstProduct()

        firstPopularItem.shouldBeEqualToDifferentTypeIgnoringFields(
            firstProductItem,
            ProductItem::image,
            ProductItem::btnDecrement,
            ProductItem::btnIncrement,
        )
    }

    @Test
    @DisplayName("Все популярные продукты совпадают с продуктами на странице Products")
    fun allPopularMatchesAllProducts() {
        val allPopularItems = MainPage().getAllPopularProduct()

        MainPage().navigateHeader().clickLink("Products")

        val allProducts = ProductsPage().getAllProducts()

        allPopularItems.forEach { popularItem ->
            val match = allProducts.find { it.name == popularItem.name }
            match.shouldNotBeNull()
            popularItem.shouldBeEqualToDifferentTypeIgnoringFields(
                match,
                ProductItem::image,
                ProductItem::btnDecrement,
                ProductItem::btnIncrement
            )
        }
    }
}