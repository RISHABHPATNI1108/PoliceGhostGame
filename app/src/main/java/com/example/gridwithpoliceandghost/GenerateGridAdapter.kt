package com.example.gridwithpoliceandghost

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.gridwithpoliceandghost.model.GeneratedGrid

class GenerateGridAdapter : RecyclerView.Adapter<GenerateGridAdapter.GenerateGridViewHolder>() {

    var gridList: List<GeneratedGrid> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GenerateGridViewHolder {
       return GenerateGridViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.grid_generate_activity , parent, false))
    }

    override fun getItemCount(): Int {
        return gridList.count()
    }

    override fun onBindViewHolder(holder: GenerateGridViewHolder, position: Int) {
        holder.bind(gridList[position])
    }


    class GenerateGridViewHolder(var view: View) : ViewHolder(view) {

        fun bind(grid: GeneratedGrid) {
            if (grid.isPolice) {
                view.findViewById<TextView>(R.id.tv_grid).text = "Police"
            } else if (grid.isGhost) {
                view.findViewById<TextView>(R.id.tv_grid).text = "Ghost"
            }
        }
    }

}