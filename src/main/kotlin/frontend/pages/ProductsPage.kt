package org.example.frontend.pages

import com.codeborne.selenide.ElementsCollection
import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup
import org.example.frontend.helpers.Wrappers.Companion.byDataTestId

class ProductsPage {

    private val txtTitle get() = element(byDataTestId("products-title"))
    private val listItems get() = elements(byDataTestGroup("product-card"))
    private val productCardName get() = elements(byDataTestGroup("product-card-name"))
    private val productCardDescription get() = element(byDataTestGroup("product-card-description"))

    @Step("Получить название страницы продуктов")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Получить список продуктов на странице")
    fun getProducts(): ElementsCollection {
        return listItems
    }

    @Step("Получить название карточки продуктов")
    fun getCardName(): ElementsCollection {
       return productCardName
    }

    @Step("Получить описание карточки продукта")
    fun getCardDescription(): String {
        return productCardDescription.text
    }
}