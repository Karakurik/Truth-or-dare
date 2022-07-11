package ru.itis.team4.truth_or_dare.presentation.result_screen

import androidx.recyclerview.widget.RecyclerView
import ru.itis.team4.truth_or_dare.databinding.ItemResultsBinding
import ru.itis.team4.truth_or_dare.presentation.main_screen.PlayerRegistration

class ResultRecordHolder(private val binding: ItemResultsBinding) : RecyclerView.ViewHolder(binding.root) {

    fun onBind(player: PlayerRegistration) {
        with(binding) {
            tvPlayerName.text = player.getNamePlayer()!!
            tvPlayerMoves.text = "${player.truthsCount} правда/ ${player.daresCount} действие/ ${player.giveUpsCount} сдался"
            tvPlayerScore.text = player.points.toString()
        }
    }
}