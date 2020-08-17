package com.diegofajardo.stackexchangeapp.data

import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerBadgeCounts
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerUser
import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.utils.SimpleDateConverter
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

    @Test
    fun toDetailUser() {
        val user = User(
            1,
            "username",
            "reputation",
            BadgeCounts(0, 1, 2),
            "loc",
            "age",
            1L,
            "someUrl"
        )

        val dateConverter = SimpleDateConverter()
        val detailUser = user.toDetailUser(dateConverter)

        assertTrue(detailUser.username == "username")
        assertTrue(detailUser.reputation == "reputation")
        assertTrue(detailUser.bronzeBadges == "0")
        assertTrue(detailUser.silverBadges == "1")
        assertTrue(detailUser.goldBadges == "2")
        assertTrue(detailUser.location == "loc")
        assertTrue(detailUser.age == "age")
        assertTrue(detailUser.creationDate == dateConverter.getDateAsString(1L))
        assertTrue(detailUser.profileImageUrl == "someUrl")
    }
}