package com.giga.aplicacion

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object Configuration {
    val URL_BASE = "https://jsonplaceholder.typicode.com/"

    fun obtenerConfiguracionRetrofit():ApiWeb{
        var objRetrofit = Retrofit.Builder()
            .baseUrl(URL_BASE)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        var apiWeb = objRetrofit.create(ApiWeb::class.java)
        return apiWeb
    }
}