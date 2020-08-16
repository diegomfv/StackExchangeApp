package com.diegofajardo.stackexchangeapp.ui.detail

import android.app.Application
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.User
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class DetailActivityViewModelTest {

    @get:Rule
    val rule = InstantTaskExecutorRule()

    @Mock
    lateinit var app: Application

    private val user: User = getFakeUser()

    private lateinit var detailActivityViewModel: DetailActivityViewModel

    private val observer: Observer<DetailActivityViewModel.UiModel> = mock()

    @Before
    fun setUp() {
        detailActivityViewModel = DetailActivityViewModel(app, user)
    }

    @Test
    fun `when viewModel is loaded the data is displayed`() {
        detailActivityViewModel.model.observeForever(observer)

        verify(observer, times(1))
            .onChanged(DetailActivityViewModel.UiModel.Content(user))

    }

    private fun getFakeUser(): User {
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