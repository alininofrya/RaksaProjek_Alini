package com.example.projek_alini

data class Kondisi(val nama: String, val kategori: String, val langkah: Int)

object KondisiData {
    val list = listOf(
        Kondisi("Pingsan", "Umum", 3),
        Kondisi("Luka / Pendarahan", "Luka", 3),
        Kondisi("Luka Bakar", "Panas", 4),
        Kondisi("Tersedak", "Umum", 3),
        Kondisi("Keseleo", "Sendi", 4),
        Kondisi("Kecelakaan Ringan", "Luka", 4)
    )
}