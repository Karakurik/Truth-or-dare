package ru.itis.team4.truth_or_dare.presentation.result_screen

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import ru.itis.team4.truth_or_dare.databinding.ItemResultsBinding
import ru.itis.team4.truth_or_dare.presentation.main_screen.PlayerRegistration

class ResultRecordAdapter(private val list: ArrayList<PlayerRegistration>)
    : RecyclerView.Adapter<ResultRecordHolder>() {
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ResultRecordHolder = ResultRecordHolder(
        ItemResultsBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false))

    override fun onBindViewHolder(holder: ResultRecordHolder, position: Int) {
        holder.onBind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }
}