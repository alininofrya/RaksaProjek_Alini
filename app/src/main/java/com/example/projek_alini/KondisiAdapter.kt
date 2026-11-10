package com.example.projek_alini

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import com.example.projek_alini.databinding.ItemKondisiListBinding

class KondisiAdapter(context: Context, private val data: List<Kondisi>) :
    ArrayAdapter<Kondisi>(context, 0, data) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val b = if (convertView == null) {
            ItemKondisiListBinding.inflate(LayoutInflater.from(context), parent, false)
        } else {
            ItemKondisiListBinding.bind(convertView)
        }
        val k = data[position]
        b.tvInisial.text = k.nama.first().toString()
        b.tvNama.text = k.nama
        b.tvInfo.text = "${k.langkah} langkah · ${k.kategori}"
        return b.root
    }
}