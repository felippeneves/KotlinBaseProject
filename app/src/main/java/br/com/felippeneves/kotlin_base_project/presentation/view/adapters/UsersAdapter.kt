package br.com.felippeneves.kotlin_base_project.presentation.view.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.felippeneves.kotlin_base_project.databinding.ItemUserBinding
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt

class UsersAdapter(
    private val users: MutableList<UserEnt>,
    private val deleteListener: (UserEnt) -> Unit,
    private val updateListener: (UserEnt) -> Unit,
) : RecyclerView.Adapter<UsersAdapter.UsersViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): UsersAdapter.UsersViewHolder {
        val itemView =
            ItemUserBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return UsersViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: UsersAdapter.UsersViewHolder, position: Int) {
        val user = users[position]

        with(holder) {
            binding.tvName.text = "Name: ${user.firstName} ${user.lastName}"
            binding.tvAge.text = "Age: ${user.age.toString()} years old"
            binding.vSeparator.visibility =
                if (position == users.lastIndex) View.GONE else View.VISIBLE
            binding.ibDelete.setOnClickListener {
                deleteListener(user)
            }
            binding.ibEdit.setOnClickListener {
                updateListener(user)
            }
        }
    }

    override fun getItemCount() = users.size

    inner class UsersViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)

    fun deleteItem(user: UserEnt) {
        val indexOf = users.indexOf(user)
        users.remove(user)
        notifyItemRemoved(indexOf)
    }
}