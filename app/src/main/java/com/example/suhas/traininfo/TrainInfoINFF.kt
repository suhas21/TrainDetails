package com.example.suhas.traininfo

import com.example.suhas.traininfo.TrainInfoJSONClasses.TrainInfoPOJO
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TrainInfoINFF {
    @GET("v2/name-number/train/{num}/apikey/91umr8ozt9/")
    fun  getName(@Path("num") num:Int): Call<TrainInfoPOJO>
}