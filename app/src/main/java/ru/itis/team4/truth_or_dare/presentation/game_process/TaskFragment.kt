package ru.itis.team4.truth_or_dare.presentation.game_process

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentTaskBinding
import ru.itis.team4.truth_or_dare.presentation.game_process.GameProcessFragment.Companion.players
import ru.itis.team4.truth_or_dare.presentation.main_screen.PlayerRegistration

class TaskFragment : Fragment(R.layout.fragment_task) {

    private var _binding: FragmentTaskBinding? = null
    private val binding get() = _binding!!
    private var player: PlayerRegistration? = null

    private var currentRefreshes: Int = 0

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        _binding = FragmentTaskBinding.bind(view)

        with(binding) {
            arguments?.getStringArray(KEY)?.let { data ->
                tvTitle.text = data[0]
                player = players[data[1].toInt()]
                tvTask.text = getTask()
            }

            ibCancel.setOnClickListener {
                player!!.giveUpsCount++
                findNavController().navigateUp()
            }

            ibRefresh.setOnClickListener {
                if (currentRefreshes < MAX_REFRESHES) {
                    tvTask.text = getTask()
                    currentRefreshes++
                } else {
                    Toast.makeText(context, "Пора бы выполнить задание", Toast.LENGTH_SHORT).show()
                }
            }

            ibDone.setOnClickListener {
                player!!.points += 10

                if (tvTitle.text == "Правда") {
                    player!!.truthsCount++
                } else {
                    player!!.daresCount++
                }

                findNavController().navigateUp()
            }
        }
    }

    private fun getTask(): String {
        val task = if (binding.tvTitle.text == "Правда") {
            truthQuestions.elementAt((0 until truthQuestions.size).random())
        } else {
            dareQuestions.elementAt((0 until dareQuestions.size).random())
        }

        return if (task.contains("PLAYER")) {
            task.replace(
                "PLAYER",
                players.filter {
                    it != player
                }[(0 until players.size).random()].getNamePlayer()!!
            )
        } else {
            task
        }
    }

    companion object {
        private const val MAX_REFRESHES = 4

        private const val KEY = "title"
        fun createBundle(array: Array<String>) = bundleOf(KEY to array)

        var truthQuestions: MutableSet<String> = mutableSetOf()
        var dareQuestions: MutableSet<String> = mutableSetOf()
    }
}