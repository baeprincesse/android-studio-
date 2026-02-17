package com.example.ba2a

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.doOnTextChanged
import com.google.android.material.button.MaterialButton
import com.google.android.material.textfield.TextInputEditText

class signupActivity : AppCompatActivity() {

    private lateinit var Email: TextInputEditText
    private lateinit var Phone: TextInputEditText
    private lateinit var Password: TextInputEditText
    private lateinit var Gender: RadioGroup
    private lateinit var btnSignup: MaterialButton

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_signup)

        // 1. Initialize Views
        Email = findViewById(R.id.EmailSignup)
        Phone = findViewById(R.id.Phone)
        Password = findViewById(R.id.PasswordSignup)
        Gender = findViewById(R.id.Gender)
        btnSignup = findViewById(R.id.btnSignup)

        // Start with button disabled until validated
        btnSignup.isEnabled = false

        // 2. Real-time validation
        val textWatcher = {
            validate()
        }

        Email.doOnTextChanged { _, _, _, _ -> validate() }
        Phone.doOnTextChanged { _, _, _, _ -> validate() }
        Password.doOnTextChanged { _, _, _, _ -> validate() }
        Gender.setOnCheckedChangeListener { _, _ -> validate() }

        // 3. Signup Button Click
        btnSignup.setOnClickListener {
            val selectedGenderId = Gender.checkedRadioButtonId
            val gender = findViewById<RadioButton>(selectedGenderId).text.toString()

            Toast.makeText(this, "Account created for $gender", Toast.LENGTH_SHORT).show()
            // Return to login or go to home
            finish()
        }
    }

    private fun validate() {
        val email = Email.text.toString().trim()
        val phone = Phone.text.toString().trim()
        val password = Password.text.toString().trim()
        val isGenderSelected = Gender.checkedRadioButtonId != -1

        // Enable button only if all fields are filled
        btnSignup.isEnabled = email.isNotEmpty() &&
                phone.isNotEmpty() &&
                password.length >= 6 &&
                isGenderSelected
    }
}