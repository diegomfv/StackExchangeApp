package com.diegofajardo.stackexchangeapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.diegofajardo.stackexchangeapp.R
import com.diegofajardo.stackexchangeapp.domain.User

class DetailActivity : AppCompatActivity() {

    companion object {
        const val ARGUMENT_USER = "arg_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        val user = intent?.extras?.getParcelable<User>(ARGUMENT_USER)
    }

}