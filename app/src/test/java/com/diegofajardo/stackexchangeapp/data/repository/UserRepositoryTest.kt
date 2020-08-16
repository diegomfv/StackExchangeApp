package com.diegofajardo.stackexchangeapp.data.repository

import com.diegofajardo.stackexchangeapp.data.model.OnlyInnameQueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.RemoteDataSource
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
class UserRepositoryTest {

    @Mock
    lateinit var remoteDataSource: RemoteDataSource

    @InjectMocks
    lateinit var userRepository: UserRepository

    @Test
    fun getUsers_whenCalled_remoteDataSource_getUsers_isCalled_with_same_queryModel() {
        val queryModel = OnlyInnameQueryModel("some value")
        whenever(remoteDataSource.getUsers(queryModel)).doReturn(Observable.empty())
        userRepository.getUsers(queryModel).blockingSubscribe()
        verify(remoteDataSource, times(1)).getUsers(queryModel)
    }
}