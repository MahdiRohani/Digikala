package com.project.digikala.data.remote

import com.project.digikala.data.model.ResponseResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Response

abstract class BaseApiResult {

    suspend fun <T> safeApiCall(apiCall : suspend ()-> Response<ResponseResult<T>>) : NetworkResult<T> =
        withContext(Dispatchers.IO){
            try {
                val response = apiCall()
                if (response.isSuccessful){
                    val body = response.body()
                    body?.let {
                        return@withContext NetworkResult.Success(body.message,body.data)
                    }
                }
                return@withContext error("code is ${response.code()}, message : ${response.message()}")
            }catch (e : Exception){
                return@withContext error(e.message?: e.toString())

            }
        }


    private fun <T> error(errorMessage : String) : NetworkResult<T> =
        NetworkResult.Error("Api call failed : $errorMessage")
}