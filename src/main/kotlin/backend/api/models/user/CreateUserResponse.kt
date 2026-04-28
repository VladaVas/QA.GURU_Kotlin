package org.example.backend.api.models.user

data class CreateUserResponse(
    var id: Int,
    var email: String,
    var username: String,
    var createdAt: Long
)
