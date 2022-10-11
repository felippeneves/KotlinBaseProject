package br.com.felippeneves.kotlin_base_project.domain.use_case.user

import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt

interface UserUseCase {
    suspend fun getUsers(): List<UserEnt>

    suspend fun getUserById(id: Int): UserEnt

    suspend fun addUser(user: UserDbo)

    suspend fun deleteUser(user: UserDbo)

    suspend fun updateUser(user: UserDbo)
}