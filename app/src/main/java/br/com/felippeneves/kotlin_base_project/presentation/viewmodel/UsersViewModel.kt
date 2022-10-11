package br.com.felippeneves.kotlin_base_project.presentation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt
import br.com.felippeneves.kotlin_base_project.domain.use_case.user.UserUseCase
import kotlinx.coroutines.launch

class UsersViewModel(
    private val userUseCase: UserUseCase
) : ViewModel() {

    private val _users = MutableLiveData<List<UserEnt>>()
    val users: LiveData<List<UserEnt>> = _users

    private val _userDeleted = MutableLiveData<UserEnt>()
    val userDeleted: LiveData<UserEnt> = _userDeleted

    fun getUsers() {
        viewModelScope.launch {
            val listUser = userUseCase.getUsers()
            _users.value = listUser
        }
    }

    fun deleteUser(user: UserEnt) {
        viewModelScope.launch {
            userUseCase.deleteUser(UserDbo(id_user = user.id))
            _userDeleted.value = user
        }
    }
}