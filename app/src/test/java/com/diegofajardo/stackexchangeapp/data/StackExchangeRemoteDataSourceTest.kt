package com.diegofajardo.stackexchangeapp.data

import com.diegofajardo.stackexchangeapp.data.model.OnlyInnameQueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.StackExchangeRemoteDataSource
import com.diegofajardo.stackexchangeapp.data.source.server.adapter.GetUsersQueryAdapter
import com.diegofajardo.stackexchangeapp.data.source.server.model.Items
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerBadgeCounts
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerUser
import com.diegofajardo.stackexchangeapp.domain.User
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import com.nhaarman.mockitokotlin2.whenever
import io.reactivex.Observable
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class StackExchangeRemoteDataSourceTest {

    @Mock
    lateinit var getUsersQueryAdapter: GetUsersQueryAdapter

    @InjectMocks
    lateinit var stackExchangeRemoteDataSource: StackExchangeRemoteDataSource

    @Test
    fun `getUsers when called getUsersQueryAdapter_getUsers is called`() {
        val queryModel = OnlyInnameQueryModel("value")
        whenever(getUsersQueryAdapter.getUsers(queryModel)).doReturn(Observable.empty())

        stackExchangeRemoteDataSource.getUsers(queryModel).blockingSubscribe()
        verify(getUsersQueryAdapter, times(1)).getUsers(queryModel)
    }

    @Test
    fun `getUsers when called and serverUsers are returned are mapped to domain User`() {
        val queryModel = OnlyInnameQueryModel("value")
        whenever(getUsersQueryAdapter.getUsers(queryModel)).doReturn(
            Observable.just(
                Items(getServerUserList())
            )
        )

        val users = stackExchangeRemoteDataSource.getUsers(queryModel).blockingIterable()
        assertTrue(users.all { it is User })
    }

    private fun getServerUserList(): List<ServerUser> {
        return listOf<ServerUser>(
            ServerUser(1, "", "", ServerBadgeCounts(0, 1, 2), "", "", 1L, ""),
            ServerUser(2, "", "", ServerBadgeCounts(0, 1, 2), "", "", 1L, ""),
            ServerUser(3, "", "", ServerBadgeCounts(0, 1, 2), "", "", 1L, "")
        )
    }
}