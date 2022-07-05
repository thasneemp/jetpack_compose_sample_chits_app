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
class DashboardViewModel @Inject constructor(private val repository: NetworkRepository) :
    ViewModel() {
    private val currentState = MutableStateFlow<NewsListState>(NewsListState.Init)
    val mState: StateFlow<NewsListState> get() = currentState


    fun loadAllProducts() {
        viewModelScope.launch {
            repository.getAllNews().onStart {
                currentState.value = NewsListState.IsLoading(true)
            }.catch {
                currentState.value = NewsListState.IsLoading(false)
            }.collect { ml ->
                currentState.value = NewsListState.IsLoading(false)
                when (ml) {
                    is BaseResult.Success -> {
                        currentState.value = NewsListState.Data(ml.data.results ?: emptyList())
                    }
                    else -> {}
                }
            }

        }
    }

}

sealed class NewsListState {
    object Init : NewsListState()
    data class IsLoading(val isLoading: Boolean) : NewsListState()
    data class ShowToast(val message: String) : NewsListState()
    data class Data(val data: List<Result>) : NewsListState()
}