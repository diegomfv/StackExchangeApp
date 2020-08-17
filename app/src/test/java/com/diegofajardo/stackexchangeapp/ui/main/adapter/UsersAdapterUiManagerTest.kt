package com.diegofajardo.stackexchangeapp.ui.main.adapter

import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.User
import org.junit.Assert.assertTrue
import org.junit.Test


class UsersAdapterUiManagerTest {

    @Test
    fun getReputation_whenCalled_returnsUserReputation() {
        val user = getFakeUser()
        val reputation = UsersAdapterUiManager().getReputation(user)
        assertTrue(reputation == "reputation")
    }

    @Test
    fun getReputation_whenCalled_returnsUserUsername() {
        val user = getFakeUser()
        val username = UsersAdapterUiManager().getUsername(user)
        assertTrue(username == "username")
    }

    private fun getFakeUser(username: String = "username"): User {
        return User(
            1,
            "username",
            "reputation",
            BadgeCounts(1, 2, 3),
            "location",
            "10",
            1,
            "someUrl"
        )
    }
}