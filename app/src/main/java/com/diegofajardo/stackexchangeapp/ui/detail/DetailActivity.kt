package com.diegofajardo.stackexchangeapp.ui.detail

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.diegofajardo.stackexchangeapp.R
import com.diegofajardo.stackexchangeapp.di.ServiceLocator
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.ui.main.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    private lateinit var detailActivityViewModel: DetailActivityViewModel

    companion object {
        const val ARGUMENT_USER = "arg_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        subscribeToModel(getUserFromIntent())
    }

    private fun subscribeToModel (user: User?) {
        if (user == null) return //TODO Notify user
        detailActivityViewModel = ViewModelProvider(this, ServiceLocator.provideDetailActivityViewModelFactory(user))
            .get(DetailActivityViewModel::class.java)
        detailActivityViewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: DetailActivityViewModel.UiModel) {
        when (model) {
            is DetailActivityViewModel.UiModel.Content -> { fillUi(model.user) }
        }
    }

    //TODO Move to DetailActivityUiManager class
    private fun fillUi(user: User) {
        //load image avatar
        username?.text = getString(R.string.username).plus(":").plus(user.username)
        reputation?.text = getString(R.string.reputation).plus(":").plus(user.reputation)
        badges_bronze?.text = getString(R.string.bronze_badges).plus(":").plus(user.badgeCounts.bronze.toString())
        badges_silver?.text = getString(R.string.silver_badges).plus(":").plus(user.badgeCounts.silver.toString())
        badges_gold?.text = getString(R.string.gold_badges).plus(":").plus(user.badgeCounts.gold.toString())
        location?.text = getString(R.string.location).plus(":").plus(user.location)
        age?.text = getString(R.string.age).plus(":").plus(user.age)
        creation_date?.text = getString(R.string.creation_date).plus(":").plus(user.creationDate.toString())
    }

    private fun getUserFromIntent () : User? {
        return intent?.extras?.getParcelable<User>(ARGUMENT_USER)
    }
}