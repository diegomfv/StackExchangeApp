package com.diegofajardo.stackexchangeapp.data.source.server.adapter

import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import com.diegofajardo.stackexchangeapp.data.source.server.endpoint.StackExchangeServerEndpoints
import com.diegofajardo.stackexchangeapp.data.source.server.model.Items
import io.reactivex.Observable


class GetUsersQueryAdapter(private val serverEndpoints: StackExchangeServerEndpoints) {

    fun getUsers(queryModel: QueryModel): Observable<Items> {
        return serverEndpoints.getUsers(
            inname = queryModel.inname,
            site = queryModel.site,
            page = queryModel.page,
            pageSize = queryModel.pageSize,
            fromDate = queryModel.fromDate,
            toDate = queryModel.toDate,
            order = queryModel.order,
            min = queryModel.min,
            max = queryModel.max,
            sort = queryModel.sort
        )
    }

}