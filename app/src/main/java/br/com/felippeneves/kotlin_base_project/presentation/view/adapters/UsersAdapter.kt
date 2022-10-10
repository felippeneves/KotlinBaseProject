package br.com.felippeneves.kotlin_base_project.presentation.view.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.felippeneves.kotlin_base_project.databinding.ItemUserBinding
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt

class UsersAdapter(
    private val users: List<UserEnt>
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
        val category = users[position]

        with(holder) {
            binding.tvId.text = category.id.toString()
            binding.tvName.text = "${category.firstName}  ${category.lastName}"
        }
    }

    override fun getItemCount() = users.size

    inner class UsersViewHolder(val binding: ItemUserBinding) :
        RecyclerView.ViewHolder(binding.root)
}