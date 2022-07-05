package com.arch.mvvmjetpack.screen.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.arch.mvvmjetpack.data.news.Result
import com.arch.mvvmjetpack.network.BaseResult
import com.arch.mvvmjetpack.network.NetworkRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddChitsViewModel @Inject constructor(private val repository: NetworkRepository) :
    ViewModel() {
    private val currentState = MutableStateFlow<AddChitState>(AddChitState.Init)
    val mState: StateFlow<AddChitState> get() = currentState


    fun loadAllProducts() {
        viewModelScope.launch {
            repository.getAllNews().onStart {
                currentState.value = AddChitState.IsLoading(true)
            }.catch {
                currentState.value = AddChitState.IsLoading(false)
            }.collect { ml ->
                currentState.value = AddChitState.IsLoading(false)
                when (ml) {
                    is BaseResult.Success -> {
                        currentState.value = AddChitState.Data(ml.data.results ?: emptyList())
                    }
                    else -> {}
                }
            }

        }
    }

}

sealed class AddChitState {
    object Init : AddChitState()
    data class IsLoading(val isLoading: Boolean) : AddChitState()
    data class ShowToast(val message: String) : AddChitState()
    data class Data(val data: List<Result>) : AddChitState()
}