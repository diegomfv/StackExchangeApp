package com.diegofajardo.stackexchangeapp.testutils

import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerBadgeCounts
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerUser

val defaultFakeUsers = listOf<ServerUser>(
    ServerUser(1, "", "", ServerBadgeCounts(0, 1, 2), "", "", 1L, ""),
    ServerUser(2, "", "", ServerBadgeCounts(0, 1, 2), "", "", 1L, ""),
    ServerUser(3, "", "", ServerBadgeCounts(0, 1, 2), "", "", 1L, "")
)