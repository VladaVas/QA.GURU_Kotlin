package org.example.frontend.components.list

import com.codeborne.selenide.SelenideElement
import org.example.frontend.helpers.toPrice
import org.example.frontend.helpers.Wrappers.Companion.byTestGroup

class ProductItems {
    fun getItems(first: SelenideElement): ProductItem {
        return ProductItem(
            image = first.find(byTestGroup("product-card-image")),
            name = first.find(byTestGroup("product-card-name")).text,
            description = first.find(byTestGroup("product-card-description")).text,
            price = first.find(byTestGroup("product-card-price")).text.toPrice(),
            btnDecrement = first.find(byTestGroup("product-card-decrement")),
            quantity = first.find(byTestGroup("product-card-qty")).text.toInt(),
            btnIncrement = first.find(byTestGroup("product-card-increment")),
        )
    }
}

data class ProductItem(
    val image: SelenideElement,
    val name: String,
    val description: String,
    val price: Float,
    val btnDecrement: SelenideElement,
    var quantity: Int,
    val btnIncrement: SelenideElement,
)
