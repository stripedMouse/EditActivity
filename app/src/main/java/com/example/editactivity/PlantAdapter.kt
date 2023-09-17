package com.example.editactivity

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.editactivity.databinding.ActivityEditBinding
import com.example.editactivity.databinding.ActivityMainBinding
import com.example.editactivity.databinding.RecyclerLayoutBinding

class PlantAdapter : RecyclerView.Adapter<PlantAdapter.PlantViewHolder>() {
    val plantList = ArrayList<Plant>()

    class PlantViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = RecyclerLayoutBinding.bind(item)
        fun bind(plant: Plant) {
            binding.apply {
                imLayout.setImageResource(plant.imageId)
                tvTitle.text = plant.title
                tvDesc.text = plant.description
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PlantViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_layout, parent, false)
        return PlantViewHolder(view)
    }

    override fun getItemCount(): Int {
        return plantList.size
    }

    override fun onBindViewHolder(holder: PlantViewHolder, position: Int) {
        holder.bind(plantList[position])
    }

    fun addPlant(plant: Plant){
        plantList.add(plant)
        notifyDataSetChanged()
    }
}