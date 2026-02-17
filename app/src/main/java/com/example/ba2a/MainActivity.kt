package com.example.ba2a

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Makes the background gradient cover the status bar
        enableEdgeToEdge()

        setContentView(R.layout.activity_main)

        val btnEnter = findViewById<MaterialButton>(R.id.btnEnter)

        btnEnter.setOnClickListener {
            // Navigate to Login Activity
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)

            // Nice transition effect
//            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
        }
    }
}