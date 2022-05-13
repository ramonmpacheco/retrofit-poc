package com.ramon.requestwithretrofit

import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

@RestController
@RequestMapping("/admin")
class PersonController {
    @GetMapping
    fun all() {
        val retro: Retrofit = Retrofit.Builder()
            .baseUrl("  http://localhost:3000/")
            .addConverterFactory(JacksonConverterFactory.create(ObjectMapper().findAndRegisterModules()))
            .build()

        var call: Call<List<Person>> = retro.create(PersonClient::class.java).all()
        var x: List<Person>? = call.execute().body()
        println(x)
    }
}