package com.diegofajardo.stackexchangeapp.ui.main

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.diegofajardo.stackexchangeapp.data.toDomainUser
import com.diegofajardo.stackexchangeapp.testdi.TestServiceLocator
import com.diegofajardo.stackexchangeapp.testutils.SchedulerProviderTrampoline
import com.diegofajardo.stackexchangeapp.testutils.defaultFakeUsers
import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase
import com.diegofajardo.stackexchangeapp.utils.ErrorMapper
import com.diegofajardo.stackexchangeapp.utils.SchedulerProviderImpl
import com.diegofajardo.stackexchangeapp.utils.SimpleErrorMapper
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MainActivityViewModelIntegrationTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val app: Application = mock()
    private val getUsersUsecase: GetUsersUsecase = TestServiceLocator.provideFakeGetUsersUsecase()
    private val schedulerProvider: SchedulerProviderImpl = SchedulerProviderTrampoline()
    private val errorMapper: ErrorMapper = SimpleErrorMapper(app)

    private lateinit var mainActivityViewModel: MainActivityViewModel

    private val observer: Observer<MainActivityViewModel.UiModel> = mock()

    @Before
    fun setUp() {
        mainActivityViewModel =
            MainActivityViewModel(app, getUsersUsecase, schedulerProvider, errorMapper)
    }

    @Test
    fun `when getUsers is called data is loaded from server`() {
        mainActivityViewModel.model.observeForever(observer)

        runBlocking {
            mainActivityViewModel.getUsers("some query")
            verify(observer, times(1))
                .onChanged(MainActivityViewModel.UiModel.Content(defaultFakeUsers.map { it.toDomainUser() }))
        }
    }

}