package com.example.projek_alini

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.example.projek_alini.databinding.ActivityLoginBinding

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnLogin.setOnClickListener {
            // Sesuaikan ID EditText dengan yang ada di XML kamu (edtUsername / etUsername)
            val user = binding.edtUsername.text.toString().trim()
            val pass = binding.edtPassword.text.toString().trim()

            // 1. Pengecekan username dan password
            if (user.isNotEmpty() && user == pass) {

                // 2. TAMBAHKAN INI: Simpan status isLogin = true ke SharedPreferences
                val sharedPref = getSharedPreferences("UserSession", MODE_PRIVATE)
                val editor = sharedPref.edit()
                editor.putBoolean("isLogin", true)
                editor.apply()

                // 3. Pindah ke MainActivity
                startActivity(Intent(this, MainActivity::class.java))
                finish()

            } else {
                // Tampilan AlertDialog jika gagal login
                AlertDialog.Builder(this)
                    .setTitle("Login Gagal")
                    .setMessage("Silahkan coba lagi")
                    .setPositiveButton("OK") { dialog, _ -> dialog.dismiss() }
                    .show()
            }
        }
    }
}