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
class ServerBadgeCountsTest {

    @Test
    fun isSerializable () {
        val serverBadgeCounts = ServerBadgeCounts(1,2,3)
        val bundle = Bundle()
        bundle.putParcelable("key", serverBadgeCounts)

        val pServerBadgeCounts = bundle.getParcelable<ServerBadgeCounts>("key")!!

        assertTrue(pServerBadgeCounts.gold == 3)
        assertTrue(pServerBadgeCounts.silver == 2)
        assertTrue(pServerBadgeCounts.bronze == 1)
    }
}