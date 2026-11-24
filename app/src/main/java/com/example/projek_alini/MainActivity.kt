package com.example.projek_alini

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.updatePadding
import androidx.fragment.app.Fragment
import com.example.projek_alini.bantuan.BantuanFragment
import com.example.projek_alini.beranda.BerandaFragment
import com.example.projek_alini.cari.CariFragment
import com.example.projek_alini.databinding.ActivityMainBinding
import com.example.projek_alini.note.NoteFragment
import com.example.projek_alini.profil.ProfilFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val bars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            binding.toolbar.updatePadding(top = bars.top)
            v.updatePadding(left = bars.left, right = bars.right, bottom = bars.bottom)
            insets
        }

        setSupportActionBar(binding.toolbar)

        if (savedInstanceState == null) {
            replaceFragment(BerandaFragment())
        }

        binding.bottomNavigation.setOnItemSelectedListener { item ->
            when (item.itemId) {
                R.id.nav_beranda -> {
                    replaceFragment(BerandaFragment())
                    true
                }
                R.id.nav_cari -> {
                    replaceFragment(CariFragment())
                    true
                }
                R.id.nav_sos -> {
                    showSosDialog()
                    false
                }
                R.id.nav_bantuan -> {
                    replaceFragment(BantuanFragment())
                    true
                }
                R.id.nav_profil -> {
                    replaceFragment(ProfilFragment())
                    true
                }
                else -> false
            }
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return when (item.itemId) {
            R.id.action_note -> {
                replaceFragment(NoteFragment())
                true
            }
            R.id.action_web -> {
                startActivity(Intent(this, ActivityWebView::class.java))
                true
            }
            R.id.action_logout -> {
                showLogoutDialog()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    private fun showSosDialog() {
        AlertDialog.Builder(this)
            .setTitle("Hubungi 112?")
            .setMessage("Layanan darurat akan dihubungi.")
            .setPositiveButton("Hubungi") { _, _ ->
                Log.d("MainActivity", "SOS ke 112")
                startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:112")))
            }
            .setNegativeButton("Batal", null)
            .show()
    }

    fun showLogoutDialog() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi Keluar")
            .setMessage("Apakah Anda yakin ingin keluar dari aplikasi RAKSA?")
            .setPositiveButton("Ya") { _, _ ->
                getSharedPreferences("UserSession", Context.MODE_PRIVATE).edit().clear().apply()
                val intent = Intent(this, LoginActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(intent)
                finish()
            }
            .setNegativeButton("Tidak") { dialog, _ -> dialog.dismiss() }
            .show()
    }
}