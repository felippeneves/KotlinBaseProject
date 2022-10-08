package br.com.felippeneves.kotlin_base_project.data.repository.database.dao

import androidx.room.Dao
import androidx.room.Query
import br.com.felippeneves.kotlin_base_project.data.model.entities.UserDbo

@Dao
abstract class UserDao: BaseDao<UserDbo> {

    @Query("" +
            "   SELECT *        " +
            "   FROM tb_user    " +
            "")
    abstract fun getAll(): List<UserDbo>

    @Query("" +
            "   SELECT *        " +
            "   FROM tb_user    " +
            "   WHERE id_user = :id  " +
            "")
    abstract fun getByKey(id: Int): UserDbo
}