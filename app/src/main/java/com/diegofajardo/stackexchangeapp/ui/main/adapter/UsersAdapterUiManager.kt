package com.diegofajardo.stackexchangeapp.ui.main.adapter

import com.diegofajardo.stackexchangeapp.domain.User

/**
 * The idea is to change how the data is displayed in the UI in a simple way without
 * modifying the adapter class nor the unit tests.
 * See commented out code.
 * */
interface UsersAdapterUiManagerImpl {
    fun getReputation (user: User) : String
    fun getUsername (user: User) : String
}

class UsersAdapterUiManager :
    UsersAdapterUiManagerImpl {

    override fun getReputation(user: User) : String {
        return user.reputation
    }

    override fun getUsername(user: User) : String {
        return user.username
    }
}

//class CapitalizeAllUsersAdapterUiManager : UsersAdapterUiManagerImpl {
//
//    override fun getReputation(user: User) : String {
//        return user.reputation.capitalize()
//    }
//
//    override fun getUsername(user: User) : String {
//        return user.username.capitalize()
//    }
//}