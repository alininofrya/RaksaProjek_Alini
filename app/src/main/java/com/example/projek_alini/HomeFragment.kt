package com.example.projek_alini

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ListView
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar

class HomeFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)

        Log.d("HomeFragment", "Fragment Home Berhasil Dimuat")

        val lvCustom = view.findViewById<ListView>(R.id.listViewGuide)
        val dataList = listOf(
            GuideModel("Pertolongan Pertama: Luka Bakar Ringan"),
            GuideModel("Pertolongan Pertama: Pingsan"),
            GuideModel("Pertolongan Pertama: Mimisan")
        )

        val adapter = GuideAdapter(requireContext(), dataList)
        lvCustom.adapter = adapter

        lvCustom.setOnItemClickListener { _, _, position, _ ->
            val selectedItem = dataList[position]

            Snackbar.make(view, "Membuka: ${selectedItem.title}", Snackbar.LENGTH_SHORT).show()

            val intent = Intent(requireContext(), DetailActivity::class.java)
            intent.putExtra("EXTRA_TITLE", selectedItem.title)
            startActivity(intent)
        }

        return view
    }
}