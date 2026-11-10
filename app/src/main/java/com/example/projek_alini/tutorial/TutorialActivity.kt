package com.example.projek_alini.tutorial

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.viewpager2.widget.ViewPager2
import com.example.projek_alini.LoginActivity
import com.example.projek_alini.MainActivity
import com.example.projek_alini.databinding.ActivityTutorialBinding

class TutorialActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTutorialBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityTutorialBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val fragmentsList = listOf(
            Tutorial1Fragment(),
            Tutorial2Fragment(),
            Tutorial3Fragment()
        )
        val adapter = TutorialFragmentAdapter(this, fragmentsList)
        binding.tutorialViewPager.adapter = adapter
        binding.dotIndicator.attachTo(binding.tutorialViewPager)

        binding.tutorialViewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                val last = position == fragmentsList.lastIndex
                binding.btnNext.text = if (last) "Mulai" else "Lanjut"
                binding.btnSkip.visibility = if (last) View.INVISIBLE else View.VISIBLE
                Log.d("Tutorial", "Halaman ke-${position + 1}")
            }
        })

        binding.btnNext.setOnClickListener {
            if (binding.tutorialViewPager.currentItem == fragmentsList.lastIndex) {
                selesai()
            } else {
                binding.tutorialViewPager.currentItem += 1
            }
        }
        binding.btnSkip.setOnClickListener { selesai() }
    }

    private fun selesai() {
        getSharedPreferences("raksa_pref", MODE_PRIVATE).edit()
            .putBoolean("tutorial_done", true)
            .apply()

        val isLoggedIn = getSharedPreferences("UserSession", MODE_PRIVATE)
            .getBoolean("isLogin", false)

        val tujuan = if (isLoggedIn) {
            MainActivity::class.java
        } else {
            LoginActivity::class.java
        }

        startActivity(Intent(this, tujuan))
        finish()
    }
}