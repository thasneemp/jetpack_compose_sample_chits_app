package com.arch.mvvmjetpack.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arch.mvvmjetpack.data.news.Result
import com.arch.mvvmjetpack.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ChitsDetailsViewModel @Inject constructor(private val repository: NetworkRepository) :
    ViewModel() {
    private val currentState = MutableStateFlow<ChitsDetails>(ChitsDetails.Init)
    val mState: StateFlow<ChitsDetails> get() = currentState


    fun loadAllProducts() {
        viewModelScope.launch {


        }
    }

}

sealed class ChitsDetails {
    object Init : ChitsDetails()
    data class IsLoading(val isLoading: Boolean) : ChitsDetails()
    data class ShowToast(val message: String) : ChitsDetails()
    data class Data(val data: List<Result>) : ChitsDetails()
}