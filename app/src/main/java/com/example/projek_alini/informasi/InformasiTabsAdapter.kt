package com.example.projek_alini.informasi

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class InformasiTabsAdapter(activity: FragmentActivity) :
    FragmentStateAdapter(activity) {

    // Jumlah total tab yang ada
    override fun getItemCount(): Int = 3

    // Menentukan Fragment yang ditampilkan berdasarkan posisi tab
    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> TabPanduanFragment()
            1 -> TabKontakFragment()
            2 -> TabPerlengkapanFragment()
            else -> throw IllegalStateException("Posisi tidak valid")
        }
    }
}