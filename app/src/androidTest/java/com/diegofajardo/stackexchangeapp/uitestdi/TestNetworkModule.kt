package com.diegofajardo.stackexchangeapp.uitestdi

import com.diegofajardo.stackexchangeapp.data.source.server.endpoint.StackExchangeServerEndpoints
import com.diegofajardo.stackexchangeapp.data.source.server.model.Items
import com.diegofajardo.stackexchangeapp.testutils.UiTestDefaultValues
import io.reactivex.Observable

object TestNetworkModule {
    val fakeStackExchangeServerEndpoints: StackExchangeServerEndpoints by lazy { FakeStackExchangeServerEndpoints() }
}

class FakeStackExchangeServerEndpoints : StackExchangeServerEndpoints {

    override fun getUsers(
        inname: String,
        site: String,
        page: Int,
        pageSize: Int,
        fromDate: Int?,
        toDate: Int?,
        order: String,
        min: String?,
        max: String?,
        sort: String
    ): Observable<Items> {
        return Observable.just(Items(UiTestDefaultValues.defaultFakeUsers))
    }
}