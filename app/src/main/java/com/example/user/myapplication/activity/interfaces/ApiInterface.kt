package com.example.user.myapplication.activity.interfaces

import com.example.user.sampleprojectwithkotlin.login.LoginData
import io.reactivex.Observable
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST


interface ApiInterface {

    @POST("login")
    @FormUrlEncoded
    fun requestLogin(
            @Field("email") email: String,
            @Field("password") password: String
    ): Observable<LoginData>
}