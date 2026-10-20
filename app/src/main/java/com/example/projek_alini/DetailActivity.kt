package com.example.projek_alini

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        // Inisialisasi ID sesuai XML activity_detail.xml kamu
        val tvTitle = findViewById<TextView>(R.id.tvTitleDetail)
        val tvDesc = findViewById<TextView>(R.id.tvDescription)
        val tvSteps = findViewById<TextView>(R.id.tvFeatureList)
        val btnBack = findViewById<Button>(R.id.btnBack)

        // Mengambil judul yang diklik dari HomeFragment
        val titleExtra = intent.getStringExtra("EXTRA_TITLE") ?: "Pertolongan Pertama"
        tvTitle.text = titleExtra

        // Logika pengisian data otomatis berdasarkan item yang dipilih
        when {
            titleExtra.contains("Pingsan", ignoreCase = true) -> {
                tvDesc.text = "Pingsan terjadi akibat penurunan aliran darah sementara ke otak. Penanganan yang cepat dan tepat sangat penting untuk membantu mengembalikan kesadaran serta mencegah cedera akibat jatuh."
                tvSteps.text = "1. Baringkan korban di tempat yang aman dan teduh.\n2. Longgarkan pakaian yang ketat (kerah baju, ikat pinggang).\n3. Tinggikan posisi kaki korban sekitar 20-30 cm melebihi posisi jantung.\n4. Berikan udara segar dan hindari mengeringkan wajah dengan air dingin secara tiba-tiba."
            }
            titleExtra.contains("Mimisan", ignoreCase = true) -> {
                tvDesc.text = "Mimisan (epistaksis) umumnya tidak berbahaya dan dapat dihentikan secara mandiri dengan memberikan penekanan lembut pada pembuluh darah di bagian hidung."
                tvSteps.text = "1. Duduk tegak dan condongkan tubuh sedikit ke arah depan.\n2. Pencet bagian cuping hidung yang lunak menggunakan ibu jari dan telunjuk.\n3. Bernapaslah perlahan melalui mulut selama 10-15 menit tanpa melepas pencetan.\n4. Kompres dingin pada area pangkal hidung untuk mempercepat penghentian pendarahan."
            }
            else -> {
                // Default untuk Luka Bakar Ringan
                tvDesc.text = "Luka bakar ringan (derajat satu) dapat ditangani secara mandiri sebelum mendapatkan bantuan medis. Tindakan cepat dan tepat sangat penting untuk meredakan rasa nyeri dan mencegah infeksi."
                tvSteps.text = "1. Siram dengan air mengalir sejuk selama 10-15 menit.\n2. Hindari menggunakan es batu atau pasta gigi.\n3. Oleskan pelembap/lidah buaya bila ada.\n4. Tutup dengan kain bersih atau perban steril."
            }
        }

        // Fungsi tombol kembali
        btnBack.setOnClickListener {
            finish()
        }
    }
}