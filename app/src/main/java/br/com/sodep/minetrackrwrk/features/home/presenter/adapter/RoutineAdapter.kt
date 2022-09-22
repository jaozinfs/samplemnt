package br.com.sodep.minetrackrwrk.features.home.presenter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import br.com.sodep.minetrackrwrk.R

class RoutineAdapter : ListAdapter<Routine, RoutineAdapter.RoutineViewHolder>(RoutineDiffUtils) {

    override fun getItemCount(): Int = 4

    inner class RoutineViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoutineViewHolder = RoutineViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.adapter_list_ocupation, parent, false)
    )

    override fun onBindViewHolder(holder: RoutineViewHolder, position: Int) {
    }
}

private object RoutineDiffUtils : DiffUtil.ItemCallback<Routine>() {
    override fun areItemsTheSame(oldItem: Routine, newItem: Routine): Boolean = true
    override fun areContentsTheSame(oldItem: Routine, newItem: Routine): Boolean = true
}

data class Routine(val name: String)