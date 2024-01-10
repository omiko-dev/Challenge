package com.example.challenge.data.common

import kotlinx.coroutines.flow.flow
import retrofit2.Response

class HandleResponse {
    fun <T : Any> safeApiCall(call: suspend () -> Response<T>) = flow {
        try {
            emit(Resource.Loading(loading = true))
            val response = call()
            val body = response.body()
            if (response.isSuccessful && body != null) {
                emit(Resource.Success(data = body))
            } else {
                emit(Resource.Error(errorMessage = response.errorBody()?.string() ?: ""))
            }
        } catch (e: Throwable) {
            emit(Resource.Error(errorMessage = e.message ?: ""))
        }
        emit(Resource.Loading(loading = false))
    }
}


