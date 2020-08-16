package com.diegofajardo.stackexchangeapp.data

import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerBadgeCounts
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerUser
import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.User

fun ServerUser.toDomainUser(): User {
    return User(
        userId = userId,
        username = username,
        reputation = reputation,
        badgeCounts = serverBadgeCounts.toDomainBadgeCounts(),
        location = location,
        age = age,
        creationDate = creationDate,
        profileImageUrl = profileImageUrl
    )
}

fun ServerBadgeCounts.toDomainBadgeCounts(): BadgeCounts {
    return BadgeCounts(
        bronze = bronze,
        silver = silver,
        gold = gold
    )
}