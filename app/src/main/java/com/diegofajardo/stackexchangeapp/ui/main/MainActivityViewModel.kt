package com.diegofajardo.stackexchangeapp.ui.main

import android.annotation.SuppressLint
import android.app.Application
import androidx.lifecycle.*
import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase
import com.diegofajardo.stackexchangeapp.utils.ErrorMapper
import com.diegofajardo.stackexchangeapp.utils.Event
import com.diegofajardo.stackexchangeapp.utils.QueryBuilder
import com.diegofajardo.stackexchangeapp.utils.SchedulerProviderImpl
import io.reactivex.disposables.CompositeDisposable


class MainActivityViewModel(
    private val app: Application,
    private val getUsersUsecase: GetUsersUsecase,
    private val queryBuilder: QueryBuilder,
    private val schedulerProvider: SchedulerProviderImpl,
    private val errorMapper: ErrorMapper
) : AndroidViewModel(app) {

    private val compositeDisposable: CompositeDisposable = CompositeDisposable()

    sealed class UiModel {
        object Loading : UiModel()
        data class Content(val users: List<User>) : UiModel()
        object EmptyContent : UiModel()
        data class Error(val errorMessage: String) : UiModel()
    }

    sealed class EventModel {
        data class Navigation(val user: User) : EventModel()
    }

    private val _model = MutableLiveData<UiModel>()
    val model: LiveData<UiModel>
        get() {
            return _model
        }

    val event = MutableLiveData<Event<EventModel>>()

    @SuppressLint("CheckResult")
    fun getUsers(queryModel: QueryModel) {
        getUsersUsecase.invoke(queryModel = queryModel)
            .subscribeOn(schedulerProvider.ioScheduler)
            .toList()
            .toObservable()
            .defaultIfEmpty(emptyList())
            .observeOn(schedulerProvider.androidScheduler)
            .doOnSubscribe {
                _model.postValue(UiModel.Loading)
                compositeDisposable.add(it)
            }
            .subscribe(
                { n ->
                    if (n.isNotEmpty()) {
                        _model.value = UiModel.Content(n)
                    } else {
                        _model.value = UiModel.EmptyContent
                    }
                },
                { e ->
                    e.printStackTrace()
                    _model.value = UiModel.Error(errorMapper.getErrorMessage(e))
                }
            )
    }

    fun onUserClicked(user: User) {
        event.value = Event(EventModel.Navigation(user))
    }

    fun processQuery(editableText: String?) {
        if (editableText.isNullOrBlank()) return
        val queryModel = queryBuilder.buildQueryModel(editableText)
        getUsers(queryModel)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }

    class Factory constructor(
        private val app: Application,
        private val getUsersUsecase: GetUsersUsecase,
        private val queryBuilder: QueryBuilder,
        private val schedulerProvider: SchedulerProviderImpl,
        private val errorMapper: ErrorMapper
    ) : ViewModelProvider.AndroidViewModelFactory(app) {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainActivityViewModel(
                app = app,
                getUsersUsecase = getUsersUsecase,
                queryBuilder = queryBuilder,
                schedulerProvider = schedulerProvider,
                errorMapper = errorMapper
            ) as T
        }
    }
}