package com.example.adapter_intent_recap

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    // generating a char range from 'A' to 'Z' and converting to list
    private val list = ('A').rangeTo('Z').toList()

    class LetterViewHolder(val view: View) : RecyclerView.ViewHolder(view){
        val button: Button = view.findViewById(R.id.button_item)
    }

    // this method is called by LayoutManager to create new view holders for RecyclerView
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        // inflate the list item layout
        val layout = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        val item = list.get(position)
        holder.button.text = item.toString()
        holder.button.setOnClickListener{
            val context = holder.itemView.context
            val intent = Intent(context, DetailActivity::class.java)
            intent.putExtra(DetailActivity.LETTER, holder.button.text.toString())
            context.startActivity(intent)
        }
    }

    override fun getItemCount() = list.size
}