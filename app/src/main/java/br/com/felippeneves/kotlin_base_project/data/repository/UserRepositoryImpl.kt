package br.com.felippeneves.kotlin_base_project.data.repository

import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo
import br.com.felippeneves.kotlin_base_project.data.model.entities.toUser
import br.com.felippeneves.kotlin_base_project.data.repository.database.dao.UserDao
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt
import br.com.felippeneves.kotlin_base_project.domain.repository.UserRepository

class UserRepositoryImpl(
    private val dao: UserDao
) : UserRepository {

    override suspend fun getUsers(): List<UserEnt> {
        return dao.getAll().map { it.toUser() }
    }

    override suspend fun getUserById(id: Int): UserEnt {
        return dao.getByKey(id).toUser()
    }

    override suspend fun insertUser(user: UserDbo) {
        dao.insert(user)
    }

    override suspend fun deleteUser(user: UserDbo) {
        dao.delete(user)
    }
}