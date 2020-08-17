package com.diegofajardo.stackexchangeapp.ui.main

import android.os.Bundle
import android.os.SystemClock
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.diegofajardo.stackexchangeapp.R
import com.diegofajardo.stackexchangeapp.di.ServiceLocator
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.extensions.hideKeyboard
import com.diegofajardo.stackexchangeapp.extensions.startActivity
import com.diegofajardo.stackexchangeapp.ui.detail.DetailActivity
import com.diegofajardo.stackexchangeapp.ui.main.adapter.UsersAdapter
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var lastClickTime: Long = 0

    lateinit var mainActivityViewModel: MainActivityViewModel
    var adapter: UsersAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        subscribeToModel()
        subscribeToSearch()
    }

    private fun subscribeToModel() {
        mainActivityViewModel =
            ViewModelProvider(this, ServiceLocator.provideMainActivityViewModelFactory())
                .get(MainActivityViewModel::class.java)
        mainActivityViewModel.model.observe(this, Observer(::updateUi))
        mainActivityViewModel.event.observe(
            this,
            Observer { it.getContentIfNotHandled()?.let { handleEvent(it) } })
    }

    private fun subscribeToSearch() {
        submit_query_button?.setOnClickListener {
            if (SystemClock.elapsedRealtime() - lastClickTime < 500) {
                return@setOnClickListener
            }
            lastClickTime = SystemClock.elapsedRealtime()
            hideKeyboard()
            mainActivityViewModel.processQuery(search_input?.text.toString())
        }
    }

    private fun updateUi(model: MainActivityViewModel.UiModel) {
        when (model) {
            MainActivityViewModel.UiModel.Loading -> showProgress()
            is MainActivityViewModel.UiModel.Content -> showContent(model.users)
            MainActivityViewModel.UiModel.EmptyContent -> showEmptyContent()
            is MainActivityViewModel.UiModel.Error -> showError(model.errorMessage)
        }
    }

    private fun handleEvent(event: MainActivityViewModel.EventModel) {
        when (event) {
            is MainActivityViewModel.EventModel.Navigation -> navigateToDetails(event.user)
        }
    }

    private fun showProgress() {
        welcome_placeholder?.visibility = View.GONE
        progress_placeholder?.visibility = View.VISIBLE
        recycler_view?.visibility = View.GONE
        empty_content_placeholder?.visibility = View.GONE
        error_placeholder?.visibility = View.GONE
    }

    private fun showContent(users: List<User>) {
        if (adapter == null) {
            adapter = UsersAdapter(ServiceLocator.provideUsersAdapterUiManagerImpl()) {
                mainActivityViewModel.onUserClicked(it)
            }
        }
        adapter?.users = users
        recycler_view?.setHasFixedSize(true)
        recycler_view?.adapter = adapter

        welcome_placeholder?.visibility = View.GONE
        progress_placeholder?.visibility = View.GONE
        recycler_view?.visibility = View.VISIBLE
        empty_content_placeholder?.visibility = View.GONE
        error_placeholder?.visibility = View.GONE
    }

    private fun showEmptyContent() {
        welcome_placeholder?.visibility = View.GONE
        progress_placeholder?.visibility = View.GONE
        recycler_view?.visibility = View.GONE
        empty_content_placeholder?.visibility = View.VISIBLE
        error_placeholder?.visibility = View.GONE
    }

    private fun showError(errorMessage: String) {
        error_message?.text = errorMessage

        welcome_placeholder?.visibility = View.GONE
        progress_placeholder?.visibility = View.GONE
        recycler_view?.visibility = View.GONE
        empty_content_placeholder?.visibility = View.GONE
        error_placeholder?.visibility = View.VISIBLE
    }

    private fun navigateToDetails(user: User) {
        startActivity<DetailActivity> {
            putExtra(DetailActivity.ARGUMENT_USER, user)
        }
    }

}