package org.example.backend.api.extension

import io.qameta.allure.Step
import retrofit2.Response
import tools.jackson.databind.ObjectMapper

class Extensions {
    companion object {
        @Step("Ger response body as object of type {T}")
        inline fun <reified T> Response<T>.getAsObject(): T {
            return try {
                body()!!
            } catch (e: Exception) {
                throw Error("Response body is null or cannot be cast to specified type: body: ${body()} | errorBody: ${errorBody()?.string()}", e)
            }
        }

        @Step("Ger response body as object of type {T}")
        inline fun <reified R> Response<*>.getErrorAsObject(): R {
            return try {
                ObjectMapper().readValue(errorBody()?.string().orEmpty(), R::class.java)
            } catch (e: Exception) {
                throw Error("Error body is null or cannot be cast to specified type: body: ${errorBody()?.string()}", e)
            }
        }
    }
}