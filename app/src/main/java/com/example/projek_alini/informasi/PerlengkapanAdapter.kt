package com.example.projek_alini.informasi

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.projek_alini.databinding.ItemPerlengkapanModelBinding

class PerlengkapanAdapter(
    private val perlengkapanList: List<PerlengkapanModel>,
    private val onItemClick: (PerlengkapanModel) -> Unit
) : RecyclerView.Adapter<PerlengkapanAdapter.PerlengkapanViewHolder>() {

    inner class PerlengkapanViewHolder(val binding: ItemPerlengkapanModelBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PerlengkapanViewHolder {
        val binding = ItemPerlengkapanModelBinding.inflate(
            LayoutInflater.from(parent.context), parent, false
        )
        return PerlengkapanViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PerlengkapanViewHolder, position: Int) {
        val item = perlengkapanList[position]
        with(holder.binding) {
            tvNamaPerlengkapan.text = item.name
            tvHargaPerlengkapan.text = item.price
            Glide.with(holder.itemView.context)
                .load(item.imageUrl)
                .into(imgPerlengkapan)
            root.setOnClickListener {
                onItemClick(item)
                Log.e("Test", item.name)
            }
        }
    }

    override fun getItemCount(): Int = perlengkapanList.size
}