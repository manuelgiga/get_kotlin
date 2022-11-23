package com.giga.aplicacion

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var apiWeb: ApiWeb


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        apiWeb = Configuration.obtenerConfiguracionRetrofit()

         consumirServicioPost()
    }

    fun consumirServicioPost(){
        var publicacion = Publicacion(0, "super post", 500, "cuerpo del super post")
        var callRespuesta = apiWeb.insertarPublicacion(publicacion)

        callRespuesta.enqueue(object : Callback<Publicacion>{
            override fun onResponse(call: Call<Publicacion>, response: Response<Publicacion>) {
                if (response.isSuccessful){
                    var nuevoPost = response.body()
                    var mensaje = "Post Creado: ${nuevoPost!!.id}. Titulo: ${nuevoPost.title}. Body: ${nuevoPost.body}"

                    Toast.makeText(applicationContext, mensaje, Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<Publicacion>, t: Throwable) {
                Toast.makeText(applicationContext, "fallo", Toast.LENGTH_SHORT).show()
            }


        })
    }

}