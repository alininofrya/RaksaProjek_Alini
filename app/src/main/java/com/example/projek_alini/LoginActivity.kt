package com.example.projek_alini

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.projek_alini.databinding.ActivityLoginBinding
import com.google.android.material.snackbar.Snackbar

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            val user = binding.edtUsername.text.toString().trim()
            val pass = binding.edtPassword.text.toString().trim()

            if (user.isNotEmpty() && user == pass) {
                getSharedPreferences("UserSession", MODE_PRIVATE).edit()
                    .putBoolean("isLogin", true)
                    .putString("nama", user)
                    .apply()
                Log.d("LoginActivity", "Login berhasil: $user")
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }

        binding.btnGuest.setOnClickListener {
            getSharedPreferences("UserSession", MODE_PRIVATE).edit()
                .putBoolean("isLogin", true)
                .putString("nama", "Pengguna Tamu")
                .apply()
            Log.d("LoginActivity", "Masuk sebagai tamu")
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.tvRegister.setOnClickListener {
            Snackbar.make(binding.root, "Fitur daftar segera hadir", Snackbar.LENGTH_SHORT).show()
        }

        binding.tvForgotPassword.setOnClickListener {
            Toast.makeText(this, "Hubungi admin untuk reset password", Toast.LENGTH_SHORT).show()
        }
    }
}