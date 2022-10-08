package br.com.felippeneves.kotlin_base_project.presentation.view.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.felippeneves.kotlin_base_project.R

class UserRegisterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_register)
    }
}