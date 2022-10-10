package br.com.felippeneves.kotlin_base_project.presentation.view.screens

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import br.com.felippeneves.kotlin_base_project.databinding.ActivityUsersBinding
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt
import br.com.felippeneves.kotlin_base_project.presentation.view.adapters.UsersAdapter
import br.com.felippeneves.kotlin_base_project.presentation.viewmodel.UsersViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class UsersActivity : AppCompatActivity() {

    private val viewModel: UsersViewModel by viewModel()

    private lateinit var binding: ActivityUsersBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUsersBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        loadingScreen()
    }

    private fun loadingScreen() {
        viewModel.users.observe(this@UsersActivity) { listUser ->
            populateUsers(listUser)
        }

        viewModel.getUsers()

        binding.fabAdd.setOnClickListener {
            startActivity(Intent(this@UsersActivity, UserRegisterActivity::class.java))
        }
    }

    private fun populateUsers(users: List<UserEnt>) {
        binding.rvUsers.adapter = UsersAdapter(users)
    }
}