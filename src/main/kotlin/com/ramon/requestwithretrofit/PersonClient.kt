package com.ramon.requestwithretrofit

import retrofit2.Call
import retrofit2.http.GET

interface PersonClient {
    @GET("person")
    fun all(): Call<List<Person>>
}