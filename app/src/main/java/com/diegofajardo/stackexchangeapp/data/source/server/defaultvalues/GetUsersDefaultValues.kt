package com.diegofajardo.stackexchangeapp.data.source.server.defaultvalues

import com.diegofajardo.stackexchangeapp.data.model.GetUsersOrderOption
import com.diegofajardo.stackexchangeapp.data.model.GetUsersSortOption

const val DEFAULT_SITE: String = "stackoverflow"
const val DEFAULT_PAGE: Int = 1
const val DEFAULT_PAGE_SIZE: Int = 20
val DEFAULT_FROM_DATE: Int? = null
val DEFAULT_TO_DATE: Int? = null
const val DEFAULT_ORDER: String = GetUsersOrderOption.DESC
val DEFAULT_MIN: String? = null
val DEFAULT_MAX: String? = null
const val DEFAULT_SORT: String = GetUsersSortOption.REPUTATION