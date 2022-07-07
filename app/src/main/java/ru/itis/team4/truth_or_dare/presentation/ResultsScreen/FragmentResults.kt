package ru.itis.team4.truth_or_dare.presentation.ResultsScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import ru.itis.team4.truth_or_dare.R
import ru.itis.team4.truth_or_dare.databinding.FragmentResultsBinding
import ru.itis.team4.truth_or_dare.presentation.ResultsScreen.ResultRecordAdapter

class FragmentResults : Fragment(R.layout.fragment_results) {
    private var _binding: FragmentResultsBinding? = null
    private val binding get() = _binding!!
    private var adapter: ResultRecordAdapter? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentResultsBinding.bind(view)
        initAdapter()
        // TODO: навигация в главное меню
        //binding.btnClose.setOnClickListener()
    }

    override fun onDestroy() {
        _binding = null
        super.onDestroy()
    }

    private fun initAdapter() {
        // TODO: добавить список игроков для инициализации адаптера
        //adapter = ResultRecordAdapter()
        binding.rvResults.adapter = adapter
    }


}