package com.example.projek_alini.beranda

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projek_alini.DetailActivity
import com.example.projek_alini.databinding.FragmentBerandaBinding
import com.example.projek_alini.informasi.InformasiActivity
import com.google.android.material.snackbar.Snackbar

class BerandaFragment : Fragment() {
    private var _binding: FragmentBerandaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBerandaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.d("BerandaFragment", "Fragment Beranda dimuat")

        binding.btnInformasi.setOnClickListener {
            val intent = Intent(requireContext(), InformasiActivity::class.java)
            startActivity(intent)
        }

        val menu = mapOf(
            binding.btnPingsan to "Pingsan",
            binding.btnLuka to "Luka / Pendarahan",
            binding.btnBakar to "Luka Bakar",
            binding.btnTersedak to "Tersedak",
            binding.btnKeseleo to "Keseleo",
            binding.btnKecelakaan to "Kecelakaan Ringan"
        )

        menu.forEach { (tombol, nama) ->
            tombol.setOnClickListener {
                Log.d("BerandaFragment", "Klik $nama")
                Snackbar.make(binding.root, "Membuka: $nama", Snackbar.LENGTH_SHORT).show()
                val intent = Intent(requireContext(), DetailActivity::class.java)
                intent.putExtra("EXTRA_TITLE", nama)
                startActivity(intent)
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}