package com.diegofajardo.stackexchangeapp.ui.main.adapter

import android.os.SystemClock
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.diegofajardo.stackexchangeapp.R
import com.diegofajardo.stackexchangeapp.domain.User
import com.diegofajardo.stackexchangeapp.utils.basicDiffUtil
import com.diegofajardo.stackexchangeapp.utils.inflate
import kotlinx.android.synthetic.main.item_user.view.*

class UsersAdapter(
    private val uiManager: UsersAdapterUiManagerImpl,
    private val listener: (User) -> Unit
) :
    RecyclerView.Adapter<UsersAdapter.ViewHolder>() {

    private var lastClickTime: Long = 0

    var users: List<User> by basicDiffUtil(
        emptyList(),
        areItemsTheSame = { old, new -> old.username == new.username }
    )

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = parent.inflate(R.layout.item_user, false)
        return ViewHolder(uiManager, view)
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val user = users[position]
        holder.bind(user)
        holder.itemView.setOnClickListener {
            if (SystemClock.elapsedRealtime() - lastClickTime < 500) {
                return@setOnClickListener
            }
            lastClickTime = SystemClock.elapsedRealtime();
            listener(user)
        }
    }

    class ViewHolder(
        private val uiManager: UsersAdapterUiManagerImpl,
        view: View
    ) : RecyclerView.ViewHolder(view) {

        fun bind(user: User) {
            itemView.reputation.text = uiManager.getReputation(user)
            itemView.username.text = uiManager.getUsername(user)
        }
    }
}