package org.example.kotlin.frontend.components.list

import com.codeborne.selenide.Selenide.elements
import org.example.frontend.helpers.Wrappers.Companion.byTestId
import org.openqa.selenium.By

class CartItems {

    private val listProducts get() = elements(byTestId("cart-item"))
}