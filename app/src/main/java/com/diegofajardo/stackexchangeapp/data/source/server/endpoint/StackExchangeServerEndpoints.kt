package com.diegofajardo.stackexchangeapp.data.source.server.endpoint

import com.diegofajardo.stackexchangeapp.data.source.server.model.Items
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface StackExchangeServerEndpoints {

    @Headers("Content-Type: application/json", "Accept: application/json")
    @GET("users")
    fun getUsers(
        @Query("inname") inname: String,
        @Query("site") site: String,
        @Query("page") page: Int,
        @Query("pagesize") pageSize: Int,
        @Query("fromDate") fromDate: Int?,
        @Query("toDate") toDate: Int?,
        @Query("order") order: String,
        @Query("min") min: String?,
        @Query("max") max: String?,
        @Query("sort") sort: String
    ): Observable<Items>

}