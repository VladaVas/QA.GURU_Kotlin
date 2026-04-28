package org.example.backend.api.endpoints

import org.example.backend.api.models.user.CreateUserRequest
import org.example.backend.api.models.user.CreateUserResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface UserEndpoints {

    @POST("users")
    fun postCreateUser(@Body body: CreateUserRequest): Call<CreateUserResponse>

}