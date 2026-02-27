package lesson_5

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test


@Feature("Extention functions lesson")
@Story("Check the capital line")
@Tag("Uppercase")
class UpperCaseTests {

    @Test
    @DisplayName("Uppercase valid")
    fun testUppercaseValid() {
        val upperCaseString = "ASDFGE"

        upperCaseString.shouldBeUpperCase().shouldBe(true)
    }

    @Test
    @DisplayName("Uppercase is not valid")
    fun testUppercaseNotValid() {
        val upperCaseString = "fsdkjfjga"

        upperCaseString.shouldBeUpperCase().shouldBe(false)
    }
}