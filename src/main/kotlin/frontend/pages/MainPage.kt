package org.example.frontend.pages

import com.codeborne.selenide.Selenide
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.frontend.components.HeaderComponent
import org.example.frontend.components.list.ProductItem
import org.example.frontend.components.list.ProductItems
import org.example.frontend.helpers.Wrappers.Companion.byTestGroup
import org.example.frontend.helpers.Wrappers.Companion.byTestId

class MainPage {

    private val txtTitle get() = element(byTestId("main-image-text"))
    private val popularProductCards get() = elements(byTestGroup("product-card"))

    @Step("Открыть главную страницу")
    fun open(): MainPage {
        Selenide.open("/")
        return this
    }

    @Step("Получить название кофейни")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Перейти к компоненту Header")
    fun navigateHeader(): HeaderComponent {
        return HeaderComponent()
    }

    @Step("Получить первый популярный продукт")
    fun getFirstPopularProduct(): ProductItem {
        return ProductItems().getItems(popularProductCards.first())
    }

    @Step("Получить все популярные продукты")
    fun getAllPopularProduct(): List<ProductItem> {
        return popularProductCards.map { ProductItems().getItems(it) }
    }
}