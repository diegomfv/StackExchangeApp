package com.diegofajardo.stackexchangeapp.ui.main

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.testutils.SchedulerProviderTrampoline
import com.diegofajardo.stackexchangeapp.usecase.GetUsersUsecase
import com.diegofajardo.stackexchangeapp.utils.ErrorMapper
import com.diegofajardo.stackexchangeapp.utils.Event
import com.diegofajardo.stackexchangeapp.utils.SchedulerProviderImpl
import com.diegofajardo.stackexchangeapp.utils.SimpleErrorMapper
import com.nhaarman.mockitokotlin2.*
import io.reactivex.Observable
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.ArgumentMatchers
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainActivityViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    private val app: Application = mock()
    private val getUsersUsecase: GetUsersUsecase = mock()
    private val schedulerProvider: SchedulerProviderImpl = SchedulerProviderTrampoline()
    private val errorMapper: ErrorMapper = SimpleErrorMapper(app)

    private lateinit var mainActivityViewModel: MainActivityViewModel

    private val observer: Observer<MainActivityViewModel.UiModel> = mock()
    private val eventObserver: Observer<Event<MainActivityViewModel.EventModel>> = mock()

    @Before
    fun setUp() {
        mainActivityViewModel = MainActivityViewModel(app, getUsersUsecase, schedulerProvider, errorMapper)
    }

    //TODO Add check for the argument (instead of any) when the way to extract the queryModel is updated
    @Test
    fun `getUsers when called getUsersUsecase_invoke is called`() {
        whenever(getUsersUsecase.invoke(any())).doReturn(Observable.fromIterable(getListFakeUsers()))

        mainActivityViewModel.getUsers("some query")
        verify(getUsersUsecase, times(1)).invoke(any())
    }

    @Test
    fun `getUsers when called and getUsersUsecase_invoke is called model is updated with Loading`() {
        whenever(getUsersUsecase.invoke(any())).doReturn(Observable.fromIterable(emptyList<User>()))
        mainActivityViewModel.model.observeForever(observer)

        mainActivityViewModel.getUsers("some query")
        verify(observer, times(1)).onChanged(MainActivityViewModel.UiModel.Loading)
    }

    @Test
    fun `getUsers when called and getUsersUsecase_invoke returns at least one item model is updated with Content(items)`() {
        val user = getFakeUser()
        whenever(getUsersUsecase.invoke(any())).doReturn(Observable.fromIterable(listOf(user)))
        mainActivityViewModel.model.observeForever(observer)

        runBlocking {
            mainActivityViewModel.getUsers("some query")
            verify(
                observer,
                times(1)
            ).onChanged(MainActivityViewModel.UiModel.Content(listOf(user)))
        }
    }

    @Test
    fun `getUsers when called and getUsersUsecase_invoke returns no items model is updated with EmptyContent`() {
        whenever(getUsersUsecase.invoke(any())).doReturn(Observable.fromIterable(emptyList<User>()))
        mainActivityViewModel.model.observeForever(observer)

        runBlocking {
            mainActivityViewModel.getUsers("some query")
            verify(observer, times(1)).onChanged(MainActivityViewModel.UiModel.EmptyContent)
        }
    }

    @Test
    fun `getUsers when called and getUsersUsecase_invoke throws error model is updated with Error(throwable_message)`() {
        val throwable = Throwable("Error")
        whenever(getUsersUsecase.invoke(any())).doReturn(Observable.error(throwable))
        mainActivityViewModel.model.observeForever(observer)

        runBlocking {
            mainActivityViewModel.getUsers("some query")
            verify(observer, times(1)).onChanged(MainActivityViewModel.UiModel.Error("Error"))
        }
    }

    @Test
    fun `getUsers when called and getUsersUsecase_invoke throws error with null message model is updated with Error(Error message not available)`() {
        val throwable = Throwable(message = null)
        whenever(getUsersUsecase.invoke(any())).doReturn(Observable.error(throwable))
        whenever(app.getString(any())).doReturn("Error message not available")
        mainActivityViewModel.model.observeForever(observer)

        runBlocking {
            mainActivityViewModel.getUsers("some query")
            verify(
                observer,
                times(1)
            ).onChanged(MainActivityViewModel.UiModel.Error("Error message not available"))
        }
    }

    @Test
    fun `onUserClicked when called event is updated with Navigation(user)`() {
        val user = getFakeUser()
        mainActivityViewModel.onUserClicked(user)
        mainActivityViewModel.event.observeForever(eventObserver)
        verify(
            eventObserver,
            times(1)
        ).onChanged(ArgumentMatchers.refEq(Event(MainActivityViewModel.EventModel.Navigation(user))))
    }

    private fun getListFakeUsers(): List<User> {
        return listOf<User>(
            getFakeUser(username = "username1"),
            getFakeUser(username = "username2"),
            getFakeUser(username = "username3")
        )
    }

    private fun getFakeUser(username: String = "username"): User {
        return User(
            1,
            "username",
            "reputation",
            BadgeCounts(1, 2, 3),
            "location",
            "10",
            1,
            "someUrl"
        )
    }

}