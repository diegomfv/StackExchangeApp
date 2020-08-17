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
class ItemsTest {

    @Test
    fun isSerializable() {
        val items = Items(listOf(getFakeServerUser()))
        val bundle = Bundle()
        bundle.putParcelable("key", items)

        val pItems = bundle.getParcelable<Items>("key")!!

        assertTrue(pItems.users.size == 1)
        assertTrue(items.users.size == pItems.users.size)

        assertTrue(pItems.users[0].userId == 1)
        assertTrue(pItems.users[0].username == "username")
        assertTrue(pItems.users[0].reputation == "rep")
        assertTrue(pItems.users[0].serverBadgeCounts.bronze == 1)
        assertTrue(pItems.users[0].serverBadgeCounts.silver == 2)
        assertTrue(pItems.users[0].serverBadgeCounts.gold == 3)
        assertTrue(pItems.users[0].location == "A")
        assertTrue(pItems.users[0].age == "10")
        assertTrue(pItems.users[0].creationDate == 10L)
        assertTrue(pItems.users[0].profileImageUrl == "SomeUrl")
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