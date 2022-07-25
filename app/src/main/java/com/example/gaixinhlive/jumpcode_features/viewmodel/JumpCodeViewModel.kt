package com.example.gaixinhlive.jumpcode_features.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import com.example.gaixinhlive.jumpcode_features.network.data.Request
import com.example.gaixinhlive.jumpcode_features.network.data.Response
import com.example.gaixinhlive.jumpcode_features.network.repository.JumpServiceImpl
import com.example.gaixinhlive.jumpcode_features.utils.UiState

class JumpCodeViewModel : ViewModel() {

    private val repo = JumpServiceImpl()

    private val _urlResponse = MutableLiveData<UiState<Response>>()
    val urlResponse: LiveData<UiState<Response>>
        get() = _urlResponse

    fun getJumpUrl(packageName: String) {
        val param = Request(
            packageName
        )
        viewModelScope.launch {
            repo.getJumpCodeUrl(param)
                .catch { err -> _urlResponse.value = UiState.Error(err) }
                .collectLatest {
                    _urlResponse.value = UiState.Success(it)
                }
        }
    }
}