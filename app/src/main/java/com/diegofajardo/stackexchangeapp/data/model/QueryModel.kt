package com.diegofajardo.stackexchangeapp.data.model

import com.diegofajardo.stackexchangeapp.data.source.server.endpoint.*

interface QueryModel {
    val inname: String
    val site: String
    val page: Int
    val pageSize: Int
    val fromDate: Int?
    val toDate: Int?
    val order: String
    val min: String?
    val max: String?
    val sort: String
}

/**
 * A query model that is built only using username data and default values.
 * */
class OnlyInnameQueryModel(
    containsUsername: String
) : QueryModel {
    override val inname: String = containsUsername
    override val site: String = DEFAULT_SITE
    override val page: Int = DEFAULT_PAGE
    override val pageSize: Int = DEFAULT_PAGE_SIZE
    override val fromDate: Int? = DEFAULT_FROM_DATE
    override val toDate: Int? = DEFAULT_TO_DATE
    override val order: String = DEFAULT_ORDER
    override val min: String? = DEFAULT_MIN
    override val max: String? = DEFAULT_MAX
    override val sort: String = DEFAULT_SORT
}