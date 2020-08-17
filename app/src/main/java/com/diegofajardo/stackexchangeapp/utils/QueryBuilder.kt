package com.diegofajardo.stackexchangeapp.utils

import com.diegofajardo.stackexchangeapp.data.model.OnlyInnameQueryModel
import com.diegofajardo.stackexchangeapp.data.model.QueryModel

interface QueryBuilder {
    fun buildQueryModel(input: String): QueryModel
}

class OnlyInnameQueryBuilder : QueryBuilder {

    override fun buildQueryModel(input: String): QueryModel {
        return OnlyInnameQueryModel(input)
    }
}