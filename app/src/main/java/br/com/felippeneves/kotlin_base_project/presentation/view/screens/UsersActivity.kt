package br.com.felippeneves.kotlin_base_project.presentation.view.screens

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
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
        binding.viewModel = viewModel
        binding.activity = this
        val view = binding.root
        setContentView(view)
        observers()
        loadingScreen()
    }

    private fun observers() {
        viewModel.users.observe(this@UsersActivity) { listUser ->
            populateUsers(listUser)
        }

        viewModel.userDeleted.observe(this@UsersActivity) {
            val adapter = binding.rvUsers.adapter as UsersAdapter
            adapter.deleteItem(it)
        }
    }

    private fun loadingScreen() {
        viewModel.getUsers()
    }

    private val getResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) {
            if(it.resultCode == Activity.RESULT_OK){
                viewModel.getUsers()
            }
        }

    fun callAddUser() {
        val intent = Intent(this@UsersActivity, UserRegisterActivity::class.java)
        getResult.launch(intent)
    }

    private fun populateUsers(users: List<UserEnt>) {
        binding.rvUsers.adapter = UsersAdapter(users as MutableList<UserEnt>) {
            deleteUser(it)
        }
    }

    private fun deleteUser(user: UserEnt) {
        viewModel.deleteUser(user)
    }
}