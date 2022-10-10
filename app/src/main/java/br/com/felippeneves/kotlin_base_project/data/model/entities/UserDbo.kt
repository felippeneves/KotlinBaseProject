package br.com.felippeneves.kotlin_base_project.data.model.entities

import androidx.room.Entity
import androidx.room.PrimaryKey
import br.com.felippeneves.kotlin_base_project.domain.model.UserEnt

private const val TABLE_NAME = "tb_user"

@Entity(
    tableName = TABLE_NAME
)
data class UserDbo (
    @PrimaryKey(autoGenerate = true) val id_user: Int = 0,
    val first_name: String?,
    val last_name: String?,
    val age: Int?
){
    constructor(first_name: String?, last_name: String?, age: Int?) : this(0, first_name, last_name, age)
}

fun UserDbo.toUser() = UserEnt(
    id = this.id_user,
    firstName = this.first_name,
    lastName = this.last_name,
    age = this.age
)