package com.diegofajardo.stackexchangeapp.ui.main.adapter

import com.diegofajardo.stackexchangeapp.domain.User
import org.junit.Assert.assertTrue
import org.junit.Test


class UsersAdapterUiManagerTest {

    @Test
    fun getReputation_whenCalled_returnsUserReputation () {
        val user = User(reputation = "1", username = "username")
        val reputation = UsersAdapterUiManager().getReputation(user)
        assertTrue(reputation == "1")
    }

    @Test
    fun getReputation_whenCalled_returnsUserUsername () {
        val user = User(reputation = "1", username = "username")
        val username = UsersAdapterUiManager().getUsername(user)
        assertTrue(username == "username")
    }
}