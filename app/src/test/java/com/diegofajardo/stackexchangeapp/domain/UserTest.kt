package com.diegofajardo.stackexchangeapp.domain

import android.os.Build
import android.os.Bundle
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class UserTest {

    @Test
    fun isSerializable() {
        val user = User(
            1,
            "username",
            "reputation",
            BadgeCounts(1, 2, 3),
            "location",
            "10",
            1,
            "someUrl"
        )

        val bundle = Bundle()
        bundle.putParcelable("key", user)

        val pUser = bundle.getParcelable<User>("key")!!

        assertTrue(pUser.userId == 1)
        assertTrue(pUser.username == "username")
        assertTrue(pUser.reputation == "reputation")
        assertTrue(pUser.badgeCounts.bronze == 1)
        assertTrue(pUser.badgeCounts.silver == 2)
        assertTrue(pUser.badgeCounts.gold == 3)
        assertTrue(pUser.location == "location")
        assertTrue(pUser.age == "10")
        assertTrue(pUser.creationDate == 1L)
        assertTrue(pUser.profileImageUrl == "someUrl")
    }

}