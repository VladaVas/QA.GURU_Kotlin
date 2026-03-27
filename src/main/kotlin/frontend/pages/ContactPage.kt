package org.example.frontend.pages

import com.codeborne.selenide.Selenide.element
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataInspector

class ContactPage {

    private val contactTitle = element(byDataInspector("src/views/ContactView.vue:10:7"))
    private val contactDescription = element(byDataInspector("src/views/ContactView.vue:11:7"))

    @Step("Получить заголовок карточки контакта")
    fun getContactTitle() : String {
        return contactTitle.text
    }

    @Step("Получить описание карточки контакта")
    fun getContactDescription() : String {
        return contactDescription.text
    }
}