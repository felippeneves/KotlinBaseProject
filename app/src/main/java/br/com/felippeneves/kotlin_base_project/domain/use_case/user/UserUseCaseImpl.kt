package br.com.felippeneves.kotlin_base_project.domain.use_case.user

import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt
import br.com.felippeneves.kotlin_base_project.domain.repository.UserRepository

class UserUseCaseImpl(
    private val repository: UserRepository
) : UserUseCase {

    override suspend fun getUsers(): List<UserEnt> {
        return repository.getUsers()
    }

    override suspend fun getUserById(id: Int): UserEnt {
        return repository.getUserById(id)
    }

    override suspend fun addUser(user: UserDbo) {
        repository.insertUser(user)
    }

    override suspend fun deleteUser(user: UserDbo) {
        repository.deleteUser(user)
    }
}