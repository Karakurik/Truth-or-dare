package ru.itis.team4.truth_or_dare.presentation.result_screen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import androidx.navigation.fragment.findNavController
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentResultsBinding
import ru.itis.team4.truth_or_dare.presentation.game_process.GameProcessFragment.Companion.players

class FragmentResults : Fragment(R.layout.fragment_results) {
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private var adapter: ResultRecordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultsBinding.bind(view)
        initAdapter()
        binding.btnClose.setOnClickListener{
            findNavController().navigate(
                R.id.action_fragmentResults_to_mainFragment
            )
        }
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun initAdapter() {
        adapter = ResultRecordAdapter(players)
        binding.rvResults.adapter = adapter
    }
}