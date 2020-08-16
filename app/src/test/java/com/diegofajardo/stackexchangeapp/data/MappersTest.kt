package com.diegofajardo.stackexchangeapp.data

import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerBadgeCounts
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerUser
import org.junit.Assert.assertTrue
import org.junit.Test

class MappersTest {

    @Test
    fun toDomainUserTest() {
        val serverUser = ServerUser(
            1,
            "username",
            "reputation",
            ServerBadgeCounts(0, 1, 2),
            "loc",
            "age",
            1L,
            "someUrl"
        )
        val user = serverUser.toDomainUser()

        with(user) {
            assertTrue(userId == 1)
            assertTrue(username == "username")
            assertTrue(reputation == "reputation")
            assertTrue(badgeCounts.bronze == 0)
            assertTrue(badgeCounts.silver == 1)
            assertTrue(badgeCounts.gold == 2)
            assertTrue(location == "loc")
            assertTrue(age == "age")
            assertTrue(creationDate == 1L)
            assertTrue(profileImageUrl == "someUrl")
        }
    }

    @Test
    fun toDomainBadgeCounts() {
        val serverBadgeCounts = ServerBadgeCounts(0, 1, 2)
        val badgeCounts = serverBadgeCounts.toDomainBadgeCounts()

        assertTrue(badgeCounts.bronze == 0)
        assertTrue(badgeCounts.silver == 1)
        assertTrue(badgeCounts.gold == 2)
    }
}