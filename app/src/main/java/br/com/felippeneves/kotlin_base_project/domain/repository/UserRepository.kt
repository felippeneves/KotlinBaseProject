package br.com.felippeneves.kotlin_base_project.domain.repository

import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt

interface UserRepository {
    suspend fun getUsers(): List<UserEnt>

    suspend fun getUserById(id: Int): UserEnt

    suspend fun insertUser(user: UserDbo)

    suspend fun deleteUser(user: UserDbo)

    suspend fun updateUser(user: UserDbo)
}