package com.diegofajardo.stackexchangeapp.ui.detail

import android.app.Application
import androidx.lifecycle.*
import com.diegofajardo.stackexchangeapp.domain.User

class DetailActivityViewModel(
    private val app: Application,
    private val user: User
) : AndroidViewModel(app) {

    sealed class UiModel {
        data class Content(val user: User) : UiModel()
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
        _model.value = UiModel.Content(user)
    }

    class Factory constructor(
        private val app: Application,
        private val user: User
    ) : ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return DetailActivityViewModel(
                app = app,
                user = user
            ) as T
        }
    }
}