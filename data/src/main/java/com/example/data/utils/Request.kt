package com.example.data.utils

object Request {
    internal suspend fun <T> networkRequest(call: suspend () -> retrofit2.Response<T>): Response<T> {
        val response = call()
        val body = response.body()
        return try {
            if (response.isSuccessful)
                if (body == null) Response.Success.Empty else Response.Success.Data(data = body)
            else
                Response.Error(exception = Exception(response.code().toString()))
        } catch (e: Exception) {
            Response.Error(exception = e)
        }
    }

    internal suspend fun <T> localRequest(call: suspend () -> T?): Response<T> {
        return try {
            val data = call.invoke()
            if (data != null) Response.Success.Data(data = data)
            else Response.Success.Empty
        } catch (e: Exception) {
            Response.Error(exception = e)
        }
    }
}
