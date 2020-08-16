package com.diegofajardo.stackexchangeapp.data.source.server.model

import android.os.Build
import android.os.Bundle
import org.junit.Assert.assertTrue
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config

@Config(sdk = [Build.VERSION_CODES.O_MR1])
@RunWith(RobolectricTestRunner::class)
class ServerUserTest {

    @Test
    fun isSerializable() {
        val serverUser = getFakeServerUser()
        val bundle = Bundle()
        bundle.putParcelable("key", serverUser)

        val pServerUser = bundle.getParcelable<ServerUser>("key")!!

        assertTrue(pServerUser.userId == 1)
        assertTrue(pServerUser.username == "username")
        assertTrue(pServerUser.reputation == "rep")
        assertTrue(pServerUser.serverBadgeCounts.gold == 3)
        assertTrue(pServerUser.serverBadgeCounts.silver == 2)
        assertTrue(pServerUser.serverBadgeCounts.bronze == 1)
        assertTrue(pServerUser.location == "A")
        assertTrue(pServerUser.age == "10")
        assertTrue(pServerUser.creationDate == 10L)
        assertTrue(pServerUser.profileImageUrl == "SomeUrl")
    }

    private fun getFakeServerUser(): ServerUser {
        return ServerUser(
            1,
            "username",
            "rep",
            ServerBadgeCounts(1, 2, 3),
            "A",
            "10",
            10,
            "SomeUrl"
        )
    }
}