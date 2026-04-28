package org.example.backend.controllers

import io.qameta.allure.Step
import org.example.backend.api.endpoints.Endpoints
import org.example.backend.api.models.user.CreateUserRequest
import org.example.backend.api.models.user.CreateUserResponse
import retrofit2.Response

class UserController: Endpoints() {

    @Step("Create user with email: {email}, username: {username}")
    fun createUser(email: String, username: String, password: String): Response<CreateUserResponse> {
        return user.postCreateUser(
            body = CreateUserRequest(
                email = email,
                username = username,
                password = password
            )
        ).execute()
    }
}
