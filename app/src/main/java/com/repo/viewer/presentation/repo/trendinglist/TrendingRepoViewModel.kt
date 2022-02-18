package com.repo.viewer.presentation.repo.trendinglist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.repo.viewer.data.model.repo.Repository
import com.repo.viewer.data.rest.GithubAPIService
import com.repo.viewer.domain.usecase.GetTrendingReposUseCase
import com.repo.viewer.domain.usecase.UpdateTrendingReposUseCase
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class TrendingRepoViewModel(
    private val getTrendingReposUseCase: GetTrendingReposUseCase,
    private val updateTrendingReposUseCase: UpdateTrendingReposUseCase
) : ViewModel() {

    private val _itemList = MutableLiveData<List<Repository>>()
    val itemList: LiveData<List<Repository>>
        get() = _itemList

    private val _originalList = ArrayList<Repository>()

    private val _state = MutableLiveData<State>()
    val state: LiveData<State>
        get() = _state


    fun getTrendingRepos() {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _state.postValue(State.InProgress)
            val list = getTrendingReposUseCase.execute()
            _state.postValue(State.Done)
            _originalList.clear()
            _originalList.addAll(list)
            _itemList.postValue(list)
        }
    }

    fun updateTrendingRepos() {
        viewModelScope.launch(Dispatchers.IO + errorHandler) {
            _state.postValue(State.InProgress)
            val list = updateTrendingReposUseCase.execute()
            _state.postValue(State.Done)
            _originalList.clear()
            _originalList.addAll(list)
            _itemList.postValue(list)
        }
    }

    fun filterRepos(text: String?) {
        if (text.isNullOrEmpty()) {
            _originalList.also {
                _itemList.value = it
            }
        } else {
            _originalList.filter {
                it.name.lowercase().contains(text.lowercase()) ||
                        it.owner.login.lowercase().contains(text.lowercase()) ||
                        it.description?.lowercase()?.contains(text.lowercase()) == true
            }.also {
                _itemList.value = it
            }
        }

    }

    private val errorHandler = CoroutineExceptionHandler { _, exception ->
        if (exception is UnknownHostException) {
            _state.postValue(State.Error(GithubAPIService.NO_INTERNET))
        } else {
            _state.postValue(State.Error(exception.message.toString()))
        }
    }


}

sealed class State {

    object Default : State()
    object InProgress : State()
    class Error(val message: String) : State()
    object Done : State()

}