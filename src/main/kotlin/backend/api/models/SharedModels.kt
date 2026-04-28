package org.example.backend.api.models

data class ErrorResponse(
    var code: Int,
    var reason: String
)

object ErrorResponses {
    val invalidCreds = ErrorResponse(
        code = 400,
        reason = "Invalid email or password"
    )
    val missingEmailOrPassword = ErrorResponse(
        code = 400,
        reason = "Missing email or password"
    )
    val userAlreadyExists = ErrorResponse(
        code = 409,
        reason = "User already exists"
    )
    val invalidEmailFormat = ErrorResponse(
        code = 400,
        reason = "Invalid email format"
    )
}