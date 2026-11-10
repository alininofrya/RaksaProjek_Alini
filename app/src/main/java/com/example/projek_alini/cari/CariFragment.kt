package com.example.projek_alini.cari

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.projek_alini.DetailActivity
import com.example.projek_alini.KondisiAdapter
import com.example.projek_alini.KondisiData
import com.example.projek_alini.databinding.FragmentCariBinding
import com.google.android.material.chip.Chip

class CariFragment : Fragment() {
    private var _binding: FragmentCariBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCariBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tampilkan("Semua")

        binding.chipGroupFilter.setOnCheckedStateChangeListener { group, checkedIds ->
            val selectedChipId = checkedIds.firstOrNull()
            if (selectedChipId != null) {
                val chip = group.findViewById<Chip>(selectedChipId)
                Toast.makeText(requireContext(), "Filter: ${chip.text}", Toast.LENGTH_SHORT).show()
                Log.d("CariFragment", "Filter: ${chip.text}")
                tampilkan(chip.text.toString())
            }
        }
    }

    private fun tampilkan(kategori: String) {
        val data = KondisiData.list.filter { kategori == "Semua" || it.kategori == kategori }
        binding.lvKondisi.adapter = KondisiAdapter(requireContext(), data)
        binding.lvKondisi.setOnItemClickListener { _, _, position, _ ->
            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("EXTRA_TITLE", data[position].nama)
            startActivity(intent)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}