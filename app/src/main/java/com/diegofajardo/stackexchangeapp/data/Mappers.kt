package com.diegofajardo.stackexchangeapp.data

import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerBadgeCounts
import com.diegofajardo.stackexchangeapp.data.source.server.model.ServerUser
import com.diegofajardo.stackexchangeapp.domain.BadgeCounts
import com.diegofajardo.stackexchangeapp.domain.DetailUser
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.utils.StackExchangeDateConverter

fun ServerUser.toDomainUser(): User {
    return User(
        userId = userId,
        username = username,
        reputation = reputation,
        badgeCounts = serverBadgeCounts.toDomainBadgeCounts(),
        location = location ?: "Location not available",
        age = age ?: "Age not available",
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

fun User.toDetailUser(dateConverter: StackExchangeDateConverter): DetailUser {
    return DetailUser(
        username = username,
        reputation = reputation,
        bronzeBadges = badgeCounts.bronze.toString(),
        silverBadges = badgeCounts.silver.toString(),
        goldBadges = badgeCounts.gold.toString(),
        location = location,
        age = age,
        creationDate = dateConverter.getDateAsString(creationDate),
        profileImageUrl = profileImageUrl
    )
}