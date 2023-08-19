package com.example.resqq

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginScreen : AppCompatActivity() {

    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login_screen)

        usernameEditText = findViewById<EditText>(R.id.textInputEditText)
        passwordEditText = findViewById<EditText>(R.id.editTextTextPassword2)
        val loginButton = findViewById<Button>(R.id.loginButton)

        usernameEditText.setOnKeyListener{ _, keyCode, event ->
            if (keyCode == KeyEvent.KEYCODE_ENTER && event.action == KeyEvent.ACTION_UP) {
                Toast.makeText(this, "Se presionó la tecla Enter", Toast.LENGTH_SHORT).show()
                return@setOnKeyListener true
            }
            false
        }

        loginButton.setOnClickListener{
            val homeIntent = Intent(this, Home::class.java)

            if(usernameEditText.text.toString() == "someone@example.com" && passwordEditText.text.toString() == "Password"){
                startActivity(homeIntent)
            }else{
                Toast.makeText(this, "Correo o contraseña incorrectas", Toast.LENGTH_SHORT).show()
            }
        }

    }
}