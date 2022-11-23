package com.giga.aplicacion

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ApiWeb {

   @POST("posts")
   fun insertarPublicacion(@Body p:Publicacion):Call<Publicacion>



}