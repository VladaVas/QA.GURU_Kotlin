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

class LoginTest: Controllers {

    @Test
    @DisplayName("Login with valid credentials should return access token")
    fun testLoginWithValidCredentials() {
        val response = auth.login("random@test.com", "password").getAsObject()

        response.accessToken.length shouldBeGreaterThan 10
        response.refreshToken.length shouldBeGreaterThan 10
    }

    @Test
    @DisplayName("Login with invalid credentials should return error")
    fun testLoginWithInvalidCredentials() {
        val response = auth.login("admin", "password").getErrorAsObject<ErrorResponse>()

        response shouldBe ErrorResponses.invalidCreds
    }

}