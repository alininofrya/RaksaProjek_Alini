package com.example.projek_alini.informasi

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.projek_alini.databinding.FragmentTabPerlengkapanBinding

class TabPerlengkapanFragment : Fragment() {

    private var _binding: FragmentTabPerlengkapanBinding? = null
    private val binding get() = _binding!!

    private val perlengkapanList = listOf(
        PerlengkapanModel("Perban Elastis", "Rp 15.000", "https://picsum.photos/seed/perban1/400/300"),
        PerlengkapanModel("Kasa Steril", "Rp 8.000", "https://picsum.photos/seed/kasa1/400/300"),
        PerlengkapanModel("Plester Luka", "Rp 10.000", "https://picsum.photos/seed/plester1/400/300"),
        PerlengkapanModel("Cairan Antiseptik", "Rp 20.000", "https://picsum.photos/seed/antiseptik1/400/300"),
        PerlengkapanModel("Alkohol 70%", "Rp 12.000", "https://picsum.photos/seed/alkohol1/400/300"),
        PerlengkapanModel("Gunting Medis", "Rp 25.000", "https://picsum.photos/seed/gunting1/400/300"),
        PerlengkapanModel("Pinset", "Rp 18.000", "https://picsum.photos/seed/pinset1/400/300"),
        PerlengkapanModel("Sarung Tangan Medis", "Rp 30.000", "https://picsum.photos/seed/sarung1/400/300"),
        PerlengkapanModel("Masker Medis", "Rp 22.000", "https://picsum.photos/seed/masker1/400/300"),
        PerlengkapanModel("Termometer Digital", "Rp 45.000", "https://picsum.photos/seed/termometer1/400/300"),
        PerlengkapanModel("Kompres Dingin Instan", "Rp 17.000", "https://picsum.photos/seed/kompres1/400/300"),
        PerlengkapanModel("Kotak P3K Lengkap", "Rp 85.000", "https://picsum.photos/seed/kotak1/400/300")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTabPerlengkapanBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val perlengkapanAdapter = PerlengkapanAdapter(perlengkapanList) { selectedItem ->
            Toast.makeText(
                requireContext(),
                "Anda memilih ${selectedItem.name}",
                Toast.LENGTH_SHORT
            ).show()
        }

        binding.rvPerlengkapan.apply {
            // Mode Grid 2 kolom
            layoutManager = GridLayoutManager(requireContext(), 2)
            // Jika ingin mode Linear:
            // layoutManager = LinearLayoutManager(requireContext())
            adapter = perlengkapanAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}