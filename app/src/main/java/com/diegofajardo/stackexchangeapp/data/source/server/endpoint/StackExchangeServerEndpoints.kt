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

    object GetUsersSortOption {
        const val REPUTATION = "reputation"
        const val CREATION = "creation"
        const val NAME = "name"
        const val MODIFIED = "modified"
    }

    object GetUsersOrderOption {
        const val DESC = "desc"
        const val ASC = "asc"
    }
}

const val DEFAULT_SITE: String = "stackoverflow"
const val DEFAULT_PAGE: Int = 1
const val DEFAULT_PAGE_SIZE: Int = 20
val DEFAULT_FROM_DATE: Int? = null
val DEFAULT_TO_DATE: Int? = null
const val DEFAULT_ORDER: String = StackExchangeServerEndpoints.GetUsersOrderOption.DESC
val DEFAULT_MIN: String? = null
val DEFAULT_MAX: String? = null
const val DEFAULT_SORT: String = StackExchangeServerEndpoints.GetUsersSortOption.REPUTATION