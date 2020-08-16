package com.diegofajardo.stackexchangeapp.data.model

import org.junit.Assert.assertTrue
import org.junit.Test

class OnlyInnameQueryModelTest {

    @Test
    fun `when instantiated inname property has same value as argument passed in constructor`() {
        val queryModel = OnlyInnameQueryModel("some value")
        assertTrue(queryModel.inname == "some value")
    }

    /* I use this test to be aware of what might be broken if I change the default values in the project.
    * It won't necessarily cause bugs but I'll be able to notice the change a be able to run more tests
    * */
    @Test
    fun `when instantiated object properties have default values`() {
        val queryModel = OnlyInnameQueryModel("some value")
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