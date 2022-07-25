package com.example.gaixinhlive.jumpcode_features.network.repository

import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import com.example.gaixinhlive.jumpcode_features.network.data.Request
import com.example.gaixinhlive.jumpcode_features.network.data.Response
import com.example.gaixinhlive.jumpcode_features.network.di.RetrofitHelper
import com.example.gaixinhlive.jumpcode_features.network.repository.JumpService

class JumpServiceImpl {

    private val service : JumpService = RetrofitHelper.service()

    suspend fun getJumpCodeUrl(param : Request): Flow<Response> = callbackFlow {
        trySend(service.getJumpCode(param))
        awaitClose()
    }
}