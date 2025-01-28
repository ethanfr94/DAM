package com.example.reto2025_mobile.API

import com.example.reto2025_mobile.data.Actividad
import com.example.reto2025_mobile.data.Contrato
import com.example.reto2025_mobile.data.Curso
import com.example.reto2025_mobile.data.Departamento
import com.example.reto2025_mobile.data.EmpTransporte
import com.example.reto2025_mobile.data.Foto
import com.example.reto2025_mobile.data.Grupo
import com.example.reto2025_mobile.data.GrupoParticipante
import com.example.reto2025_mobile.data.ProfParticipante
import com.example.reto2025_mobile.data.ProfResponsable
import com.example.reto2025_mobile.data.Profesor
import com.example.reto2025_mobile.data.PuntoInteres
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.ResponseBody
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.GET
import retrofit2.http.Multipart
import retrofit2.http.POST
import retrofit2.http.PUT
import retrofit2.http.Part
import retrofit2.http.Path
import retrofit2.http.Query
import java.io.File

interface RetrofitService {
    @GET("actividades")
    suspend fun getActividades(): List<Actividad>

    @GET("actividades/{id}")
    suspend fun getActividadById(@Path("id") id: Int): Actividad

    @GET("contratos")
    suspend fun getContratos(): List<Contrato>

    @GET("cursos")
    suspend fun getCursos(): List<Curso>

    @GET("departamentos")
    suspend fun getDepartamentos(): List<Departamento>

    @GET("gruposParticipantes")
    suspend fun getGruposParticipantes(): List<GrupoParticipante>

    @GET("profesores")
    suspend fun getProfesores(): List<Profesor>

    @GET("profesoresParticipantes")
    suspend fun getProfesoresParticipantes(): List<ProfParticipante>

    @GET("profesoresParticipantes/actividad/{id}")
    suspend fun getProfesoresParticipantesByActividadId(@Path("id") id: Int): List<ProfParticipante>

    @GET("profesoresResponsables")
    suspend fun getProfesoresResponsables(): List<ProfResponsable>

    @GET("transportes")
    suspend fun getTransportes(): List<EmpTransporte>

    @GET("grupos")
    suspend fun getGrupos(): List<Grupo>

    @GET("fotos/actividad/{id}")
    suspend fun getFotosByActividadId(@Path("id") id: Int): List<Foto>

    @GET("fotos/{idActividad}/foto")
    suspend fun getFotoActividad(@Path("idActividad") idActividad: Int, @Query("id") id: Int): retrofit2.Response<okhttp3.ResponseBody>

    @GET("fotos")
    suspend fun getFotos(): List<Foto>

    @GET("puntosinteres")
    suspend fun getPuntosInteres(): List<PuntoInteres>

    @POST("puntosinteres")
    suspend fun createPuntoInteres(@Body puntoInteres: PuntoInteres): Response<PuntoInteres>

    @DELETE("puntosinteres/{id}")
    suspend fun deletePuntoInteres(@Path("id") id: Int): Response<PuntoInteres>

    @GET("profesores/inicio")
    suspend fun login(
        @Query("correo") correo: String,
        @Query("password") password: String
    ): Profesor

    @PUT("actividades/{id}")
    suspend fun updateActividad(
        @Path("id") id: Int?,
        @Body actividad: Actividad
    ): Actividad

    @PUT("gruposParticipantes/{id}")
    suspend fun updateGrupoParticipante(
        @Path("id") id: Int?,
        @Body grupoParticipante: GrupoParticipante
    ): GrupoParticipante

    @Multipart
    @POST("fotos/{idActividad}/foto")
    suspend fun uploadPhoto(
        @Path("idActividad") idActividad: Int,
        @Query("descripcion") descripcion: String,
        @Body fichero: MultipartBody.Part
    ): Response<Foto>

    @GET("/acex/fotos/{idActividad}/foto")
    suspend fun getFoto(
        @Path("idActividad") idActividad: Int,
        @Query("id") id: Int // Parámetro de consulta 'id' para la foto
    ): ResponseBody

    @GET("/acex/fotos/actividad/{idActividad}")
    suspend fun getFotos(
        @Path("idActividad") idActividad: Int
    ): List<Foto>



}

object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("http://10.0.22.68:8080/acex/")
            //.baseUrl("http://192.168.1.134:8080/acex/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}