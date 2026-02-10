package lesson_1

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Tags
import org.junit.jupiter.api.Test

@Feature("Basic Tests")
@Story("Test of concatenation of two strings")
@Tags (Tag("regression"), Tag("string"))

class StringTest {
    @Test
    @DisplayName("Test of concatenation of two strings into one")
    fun concatenationOfTwoStrings() {
        val first = "Hello"
        val second = "World"

        val exceptedString = "HelloWorld"
        val actualString = first + second

        exceptedString shouldBe actualString
    }
}