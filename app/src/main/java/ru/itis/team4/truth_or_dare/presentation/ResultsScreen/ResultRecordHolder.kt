package ru.itis.team4.truth_or_dare.presentation.ResultsScreen

import androidx.recyclerview.widget.RecyclerView
import ru.itis.team4.truth_or_dare.databinding.ItemResultsBinding
import ru.itis.team4.truth_or_dare.presentation.ResultsScreen.ResultRecord

class ResultRecordHolder(private val binding: ItemResultsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(result: ResultRecord) {
        with(binding) {
            playername.text = result.Name
            playermoves.text = "${result.TruthCount} правда/ ${result.ActionCount} действие/ ${result.SurrenderCount} сдался"
            playerscore.text = result.Score.toString()
        }



    }

}