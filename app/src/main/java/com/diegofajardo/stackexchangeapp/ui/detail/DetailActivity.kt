package com.diegofajardo.stackexchangeapp.ui.detail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.diegofajardo.stackexchangeapp.R
import com.diegofajardo.stackexchangeapp.di.ServiceLocator
import com.diegofajardo.stackexchangeapp.domain.DetailUser
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.extensions.loadUrl
import kotlinx.android.synthetic.main.activity_detail.*


class DetailActivity : AppCompatActivity() {

    private lateinit var detailActivityViewModel: DetailActivityViewModel

    companion object {
        const val ARGUMENT_USER = "arg_user"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        configureToolbar(this)
        subscribeToModel(getUserFromIntent())
    }

    private fun subscribeToModel(user: User?) {
        if (user == null) return //TODO Notify user
        detailActivityViewModel =
            ViewModelProvider(this, ServiceLocator.provideDetailActivityViewModelFactory(user))
                .get(DetailActivityViewModel::class.java)
        detailActivityViewModel.model.observe(this, Observer(::updateUi))
    }

    private fun updateUi(model: DetailActivityViewModel.UiModel) {
        when (model) {
            is DetailActivityViewModel.UiModel.Content -> {
                fillUi(model.detailUser)
            }
        }
    }

    //TODO Move to DetailActivityUiManager class
    private fun fillUi(detailUser: DetailUser) {
        avatar?.loadUrl(detailUser.profileImageUrl)
        username?.text = getString(R.string.username).plus(": ").plus(detailUser.username)
        reputation?.text = getString(R.string.reputation).plus(": ").plus(detailUser.reputation)
        badges_bronze?.text =
            getString(R.string.bronze_badges).plus(": ").plus(detailUser.bronzeBadges)
        badges_silver?.text =
            getString(R.string.silver_badges).plus(": ").plus(detailUser.silverBadges)
        badges_gold?.text = getString(R.string.gold_badges).plus(": ").plus(detailUser.goldBadges)
        location?.text = getString(R.string.location).plus(": ").plus(detailUser.location)
        age?.text = getString(R.string.age).plus(": ").plus(detailUser.age)
        creation_date?.text =
            getString(R.string.creation_date).plus(": ").plus(detailUser.creationDate)
    }

    private fun getUserFromIntent(): User? {
        return intent?.extras?.getParcelable<User>(ARGUMENT_USER)
    }

    private fun configureToolbar(activity: AppCompatActivity?) {
        if (activity == null) return
        activity.apply {
            setSupportActionBar(findViewById(R.id.toolbar))
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            android.R.id.home -> {
                onBackPressed()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}