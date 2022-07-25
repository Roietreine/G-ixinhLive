package com.example.gaixinhlive.jumpcode_features.network.repository

import com.example.gaixinhlive.jumpcode_features.network.data.Request
import com.example.gaixinhlive.jumpcode_features.network.data.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface JumpService {

    @POST("app_conf")
    suspend fun getJumpCode(@Body param : Request): Response
}