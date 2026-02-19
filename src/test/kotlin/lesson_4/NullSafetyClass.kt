package lesson_4

import io.kotest.matchers.nulls.shouldBeNull
import io.kotest.matchers.nulls.shouldNotBeNull
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class NullSafetyClass {
    @Test
    @DisplayName("Если age и email null — должны подставляться дефолтные значения")
    fun userDefaultValue() {
        val user = DataClass(12345, "User")

        user.age?.let { println("User age was $it") } ?: run { println("Age was null") }
        user.email?.let { println("User email was $it") } ?: run { println("Email was null") }

        user.age.shouldBeNull()
        user.email.shouldBeNull()

    }

    @Test
    @DisplayName("Тест на NullSafetyExeption, если обязательные поля = null")
    fun userNameIsNotNull() {
        val user = DataClass(12345, "Lelik")

        user.name.let { println("User name was $it") }
        user.name.shouldNotBeNull()
    }

    @Test
    @DisplayName("Обновление age через apply")
    fun userApplyAge() {
        val user = DataClass(12345, "User", age = null, email = null)

        val newAge = user.apply {
            age = 13
            println("Update age info: $age")
        }

        try {
            val nonNullEmail = user.email!!
            println("Update email info: $nonNullEmail")
        } catch (e: NullPointerException) {
            println("Catch NullPointerException")
        }

        newAge.age.shouldBe(13)
        user.email.shouldBeNull()
    }
}