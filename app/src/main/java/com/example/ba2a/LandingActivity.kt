package com.example.ba2a

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class LandingActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_landing)

        val btnLogout = findViewById<MaterialButton>(R.id.btnLogout)

        // Uncommented this so the button works
        btnLogout.setOnClickListener {
            // Return to login
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish() // This prevents the user from going back to the landing page after logging out
        }
    }
}