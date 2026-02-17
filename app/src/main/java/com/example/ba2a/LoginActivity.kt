package com.example.ba2a

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout

class LoginActivity : AppCompatActivity() {

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login_activity)

        // Find Layouts (to show errors)
        val emailLayout = findViewById<TextInputLayout>(R.id.emailInputLayout)
        val passwordLayout = findViewById<TextInputLayout>(R.id.passwordInputLayout)

        // Find EditTexts
        val etEmail = findViewById<TextInputEditText>(R.id.Email)
        val etPassword = findViewById<TextInputEditText>(R.id.Password)

        val btnLogin = findViewById<MaterialButton>(R.id.btnLogin)
        val NoAccount = findViewById<TextView>(R.id.NoAccount)

        btnLogin.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()

            // Reset errors
//            emailLayout.error = null
//            passwordLayout.error = null

            // 1. Validate Email
            if (email.isEmpty()) {
                emailLayout.error = "Email is required"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                emailLayout.error = "Please enter a valid email address (e.g., name@email.com)"
            }
            // 2. Validate Password Limit (e.g., minimum 6 characters)
            else if (password.isEmpty())
                passwordLayout.error = "Password is required" else if (password.length < 8) {
                passwordLayout.error = "Password must be at least 8 characters long"
            }
            // 3. Success
            else {
                Toast.makeText(this, "Login Successful!", Toast.LENGTH_SHORT).show()
                val intent = Intent(this, LandingActivity::class.java)
                startActivity(intent)
                finish()
            }
        }

        NoAccount.setOnClickListener {
            val intent = Intent(this, signupActivity::class.java)
            startActivity(intent)
        }
    }
}