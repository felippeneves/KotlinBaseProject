package br.com.felippeneves.kotlin_base_project.presentation.viewmodel

import androidx.lifecycle.ViewModel
import br.com.felippeneves.kotlin_base_project.domain.use_case.user.UserUseCase

class UserRegisterViewModel(
    private val userUseCase: UserUseCase
) : ViewModel() {

}