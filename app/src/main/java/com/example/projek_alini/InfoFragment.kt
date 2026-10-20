package com.example.projek_alini

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import androidx.fragment.app.Fragment

class InfoFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_info, container, false)

        val lvSimple = view.findViewById<ListView>(R.id.lvSimple)

        // Simple List Item (Syarat Poin ListView Simple)
        val simpleData = arrayOf("Ambulans - 118", "Polisi - 110", "Pemadam Kebakaran - 113", "SAR - 115")

        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_list_item_1, simpleData)
        lvSimple.adapter = adapter

        // Poin Toast
        lvSimple.setOnItemClickListener { _, _, position, _ ->
            Toast.makeText(requireContext(), "Menghubungi ${simpleData[position]}", Toast.LENGTH_SHORT).show()
        }

        return view
    }
}