package backend

import io.kotest.matchers.ints.shouldBeGreaterThan
import io.kotest.matchers.shouldBe
import org.example.backend.api.extension.Extensions.Companion.getAsObject
import org.example.backend.api.extension.Extensions.Companion.getErrorAsObject
import org.example.backend.api.models.ErrorResponse
import org.example.backend.api.models.ErrorResponses
import org.example.backend.controllers.Controllers
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class UserCreateTest : Controllers {

    @Test
    @DisplayName("Create user with valid payload should return created user")
    fun testCreateUserWithValidPayload() {
        val response = user.createUser(
            email = "newUser@qa.com",
            username = "New User",
            password = "newPassword"
        ).getAsObject()

        response.id shouldBeGreaterThan 0
        response.email shouldBe "newUser@qa.com"
        response.username shouldBe "New User"
    }

    @Test
    @DisplayName("Create user with existing email should return conflict")
    fun testCreateUserWithExistingEmail() {
        val response = user.createUser(
            email = "random@test.com",
            username = "random_user",
            password = "password"
        ).getErrorAsObject<ErrorResponse>()

        response shouldBe ErrorResponses.userAlreadyExists
    }

    @Test
    @DisplayName("Create user with invalid email should return validation error")
    fun testCreateUserWithInvalidEmail() {
        val response = user.createUser(
            email = "invalid-email",
            username = "New User",
            password = "newPassword"
        ).getErrorAsObject<ErrorResponse>()

        response shouldBe ErrorResponses.invalidEmailFormat
    }
}

