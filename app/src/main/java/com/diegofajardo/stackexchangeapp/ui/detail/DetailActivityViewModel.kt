package com.diegofajardo.stackexchangeapp.ui.detail

import android.app.Application
import androidx.lifecycle.*
import com.diegofajardo.stackexchangeapp.data.toDetailUser
import com.diegofajardo.stackexchangeapp.domain.DetailUser
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.utils.StackExchangeDateConverter

class DetailActivityViewModel(
    private val app: Application,
    private val dateConverter: StackExchangeDateConverter,
    private val user: User
) : AndroidViewModel(app) {

    sealed class UiModel {
        data class Content(val detailUser: DetailUser) : UiModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            if (_model.value == null) {
                refresh()
            }
            return _model
        }

    private fun refresh() {
        val detailUser = user.toDetailUser(dateConverter)
        _model.value = UiModel.Content(detailUser)
    }

    class Factory constructor(
        private val app: Application,
        private val dateConverter: StackExchangeDateConverter,
        private val user: User
    ) : ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DetailActivityViewModel(
                app = app,
                dateConverter = dateConverter,
                user = user
            ) as T
        }
    }
}