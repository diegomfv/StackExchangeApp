package com.diegofajardo.stackexchangeapp.utils

import com.diegofajardo.stackexchangeapp.data.model.OnlyInnameQueryModel
import com.diegofajardo.stackexchangeapp.data.model.QueryModel
import org.junit.Assert.assertTrue
import org.junit.Test

class OnlyInnameQueryBuilderTest {

    @Test
    fun `buildQueryModel when called returns OnlyInnameQueryModel`() {
        val builder = OnlyInnameQueryBuilder()
        val queryModel = builder.buildQueryModel("value")
        assertTrue(queryModel is OnlyInnameQueryModel)
    }

    @Test
    fun `buildQueryModel when called returns OnlyInnameQueryModel with inname equal to string passed as argument`() {
        val builder = OnlyInnameQueryBuilder()
        val queryModel = builder.buildQueryModel("value")
        assertTrue(queryModel.inname == "value")
    }

    @Test
    fun `buildQueryModel when called returns OnlyInnameQueryModel with default values`() {
        val builder = OnlyInnameQueryBuilder()
        val queryModel = builder.buildQueryModel("value")
        assertTrue(queryModel.site == "stackoverflow")
        assertTrue(queryModel.page == 1)
        assertTrue(queryModel.pageSize == 20)
        assertTrue(queryModel.fromDate == null)
        assertTrue(queryModel.toDate == null)
        assertTrue(queryModel.order == "desc")
        assertTrue(queryModel.min == null)
        assertTrue(queryModel.max == null)
        assertTrue(queryModel.sort == "reputation")
    }
}