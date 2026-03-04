package previous_lessons.lesson_2.lesson_5

import io.kotest.matchers.shouldBe
import io.qameta.allure.Feature
import io.qameta.allure.Story
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Tag
import org.junit.jupiter.api.Test


@Feature("Extention functions lesson")
@Story("Verify phone number")
@Tag("Phone Number")

class PhoneNumberTests {

    @Test
    @DisplayName("Phone number verification test valid")
    fun testPhoneNumberValid() {
        val phoneNumber = "+1234567890"

        phoneNumber.isPhoneNumberValid().shouldBe(true)
    }

    @Test
    @DisplayName("Phone number verification test not valid")
    fun testPhoneNumberNotValid() {
        val phoneNumber = "fsdkjfjga"

        phoneNumber.isPhoneNumberValid().shouldBe(false)
    }
}