package com.diegofajardo.stackexchangeapp.data.source.server.adapter

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.endpoint.StackExchangeServerEndpoints
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
class GetUsersQueryAdapterTest {

    @Mock
    lateinit var serverEndpoints: StackExchangeServerEndpoints

    @InjectMocks
    lateinit var adapter: GetUsersQueryAdapter

    @Test
    fun `getUsers when called serverEndpoints_getUsers is called with queryModel variables as arguments`() {
        val queryModel = getFakeQueryModel()
        whenever(
            serverEndpoints.getUsers(
                getFakeQueryModel().inname,
                getFakeQueryModel().site,
                getFakeQueryModel().page,
                getFakeQueryModel().pageSize,
                getFakeQueryModel().fromDate,
                getFakeQueryModel().toDate,
                getFakeQueryModel().order,
                getFakeQueryModel().min,
                getFakeQueryModel().max,
                getFakeQueryModel().sort
            )
        ).doReturn(Observable.empty())

        adapter.getUsers(queryModel)
        verify(serverEndpoints, times(1))
            .getUsers(
                getFakeQueryModel().inname,
                getFakeQueryModel().site,
                getFakeQueryModel().page,
                getFakeQueryModel().pageSize,
                getFakeQueryModel().fromDate,
                getFakeQueryModel().toDate,
                getFakeQueryModel().order,
                getFakeQueryModel().min,
                getFakeQueryModel().max,
                getFakeQueryModel().sort
            )
    }

    private fun getFakeQueryModel(): QueryModel {
        return object : QueryModel {
            override val inname = "inname"
            override val site: String = "site"
            override val page: Int = 1
            override val pageSize: Int = 1
            override val fromDate: Int? = null
            override val toDate: Int? = null
            override val order: String = "order"
            override val min: String? = null
            override val max: String? = null
            override val sort: String = "sort"
        }
    }

}