package com.example.projek_alini.profil

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projek_alini.MainActivity
import com.example.projek_alini.databinding.FragmentProfilBinding

class ProfilFragment : Fragment() {
    private var _binding: FragmentProfilBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View {
        _binding = FragmentProfilBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val pref = requireActivity().getSharedPreferences("UserSession", Context.MODE_PRIVATE)
        val nama = pref.getString("nama", "Pengguna Tamu") ?: "Pengguna Tamu"
        binding.tvNama.text = nama
        binding.tvInisial.text = nama.first().uppercase()
        binding.tvStatus.text = if (nama == "Pengguna Tamu") "Mode Tamu" else "Pengguna RAKSA"

        binding.btnKeluar.setOnClickListener {
            (requireActivity() as MainActivity).showLogoutDialog()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}