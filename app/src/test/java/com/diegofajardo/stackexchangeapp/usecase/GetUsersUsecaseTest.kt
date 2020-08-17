package com.diegofajardo.stackexchangeapp.usecase

import com.diegofajardo.stackexchangeapp.data.model.OnlyInnameQueryModel
import com.diegofajardo.stackexchangeapp.data.repository.UserRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class GetUsersUsecaseTest {

    @Mock
    lateinit var userRepository: UserRepository

    @InjectMocks
    lateinit var getUsersUsecase: GetUsersUsecase

    @Test
    fun invoke_whenCalled_userRepository_getUsers_isCalled_with_same_queryModel() {
        val queryModel = OnlyInnameQueryModel("some value")
        whenever(userRepository.getUsers(queryModel)).doReturn(Observable.empty())
        getUsersUsecase.invoke(queryModel).blockingSubscribe()
        verify(userRepository, times(1)).getUsers(queryModel)
    }
}