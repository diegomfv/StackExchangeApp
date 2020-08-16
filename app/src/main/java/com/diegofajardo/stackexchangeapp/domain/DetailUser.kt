package com.diegofajardo.stackexchangeapp.domain

data class DetailUser(
    val username: String,
    val reputation: String,
    val bronzeBadges: String,
    val silverBadges: String,
    val goldBadges: String,
    val location: String,
    val age: String,
    val creationDate: String,
    val profileImageUrl: String
)