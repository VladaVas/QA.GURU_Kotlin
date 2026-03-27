package org.example.frontend.components

import com.codeborne.selenide.Selenide.elements
import io.kotest.assertions.fail
import io.qameta.allure.Step
import org.example.frontend.helpers.Wrappers.Companion.byDataTestGroup

class HeaderComponent {
    private val listLinks get() = elements(byDataTestGroup("nav-link"))

    @Step("Нажать на ссылку в шапке: {name}")
    fun clickLink(name: String): HeaderComponent {
        listLinks.firstOrNull { it.text.contains(name) }?.click() ?: fail("Ссылка не найдена")
        return this
    }

    @Step("Получить названия ссылок в шапке")
    fun getLinksName(): List<String> {
        return listLinks.map { it.text }
    }
}