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
class BadgeCountsTest {

    @Test
    fun isSerializable() {
        val badgeCounts = BadgeCounts(1, 2, 3)
        val bundle = Bundle()
        bundle.putParcelable("key", badgeCounts)

        val pBadgeCounts = bundle.getParcelable<BadgeCounts>("key")!!

        assertTrue(pBadgeCounts.bronze == 1)
        assertTrue(pBadgeCounts.silver == 2)
        assertTrue(pBadgeCounts.gold == 3)
    }

}