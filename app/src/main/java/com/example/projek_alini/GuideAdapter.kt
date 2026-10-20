package com.example.projek_alini

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

data class GuideModel(val title: String)

class GuideAdapter(context: Context, private val list: List<GuideModel>) :
    ArrayAdapter<GuideModel>(context, 0, list) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.activity_guide_adapter, parent, false)
        val item = list[position]

        val title = view.findViewById<TextView>(R.id.tvGuideTitle)
        title.text = item.title

        return view
    }
}