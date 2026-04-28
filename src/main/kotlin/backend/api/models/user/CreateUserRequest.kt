package org.example.backend.api.models.user

data class CreateUserRequest(
    var email: String,
    var username: String,
    var password: String
)
