package org.example.frontend.pages

import com.codeborne.selenide.Selenide.element
import com.codeborne.selenide.Selenide.elements
import com.codeborne.selenide.SelenideElement
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byTestGroup
import org.example.frontend.helpers.Wrappers.Companion.byTestId

class ProductsPage {

    private val txtTitle get() = element(byTestId("products-title"))
    private val listItems get() = elements(byTestGroup("product-card"))
    private val listCardNames get() = elements(byTestGroup("product-card-name"))
    private val listCardDescription get() = elements(byTestGroup("product-card-description"))

    @Step("Получить название страницы продуктов")
    fun getTitle(): String {
        return txtTitle.text
    }

    @Step("Получить список продуктов на странице")
    fun getProductByName(name: String): SelenideElement? {
       return listItems.firstOrNull { it.text.contains(name) }
    }

    @Step("Получить название карточки продуктов")
    fun getAllCardNames(): List<String> {
       return listCardNames.map { it.text }.toList()
    }

    @Step("Получить описание карточки продукта")
    fun getCardDescription(): List<String> {
        return listCardDescription.map { it.text }.toList()
    }
}