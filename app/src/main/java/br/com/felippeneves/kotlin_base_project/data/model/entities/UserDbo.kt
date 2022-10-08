package br.com.felippeneves.kotlin_base_project.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt

private const val TABLE_NAME = "tb_user"

@Entity(
    tableName = TABLE_NAME
)
data class UserDbo (
    @PrimaryKey val id_user: Int,
    val first_name: String?,
    val last_name: String?
)

fun UserDbo.toUser() = UserEnt(
    id = this.id_user,
    firstName = this.first_name,
    lastName = this.last_name
)