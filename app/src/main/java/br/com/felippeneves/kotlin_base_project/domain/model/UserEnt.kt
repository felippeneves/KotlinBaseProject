package br.com.felippeneves.kotlin_base_project.domain.model

import java.io.Serializable

data class UserEnt (
    val id: Int,
    val firstName: String?,
    val lastName: String?,
    val age: Int?
) : Serializable