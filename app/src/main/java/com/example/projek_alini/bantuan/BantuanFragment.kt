package com.example.projek_alini.bantuan

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projek_alini.databinding.FragmentBantuanBinding
import com.google.android.material.snackbar.Snackbar

class BantuanFragment : Fragment() {
    private var _binding: FragmentBantuanBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentBantuanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val layanan = arrayOf(
            "Darurat Umum - 112",
            "Ambulans/IGD - 119",
            "Polisi - 110",
            "Pemadam Kebakaran - 113",
            "Basarnas/SAR - 115"
        )

        binding.lvLayanan.adapter =
            ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, layanan)

        binding.lvLayanan.setOnItemClickListener { _, _, position, _ ->
            val nomor = layanan[position].substringAfterLast("- ").trim()
            Log.d("BantuanFragment", "Hubungi $nomor")
            Toast.makeText(requireContext(), "Menghubungi $nomor", Toast.LENGTH_SHORT).show()
            startActivity(Intent(Intent.ACTION_DIAL, Uri.parse("tel:$nomor")))
        }

        binding.btnBagikan.setOnClickListener {
            Snackbar.make(binding.root, "Membuka menu bagikan", Snackbar.LENGTH_SHORT).show()
            val kirim = Intent(Intent.ACTION_SEND).apply {
                type = "text/plain"
                putExtra(Intent.EXTRA_TEXT, "Saya butuh bantuan darurat. Mohon hubungi saya.")
            }
            startActivity(Intent.createChooser(kirim, "Bagikan lewat"))
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}