package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.viewmodel.R
import com.example.viewmodel.ui.viewModels.HomeViewModel
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

        //TODO: 1. prerobit na databinding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)

        //TODO: 2. nahradit observer databindingom v xml
        homeViewModel.word.observe(this) { words_text.text = it }

        //TODO: 5. nahradit listener databindingom v xml
        word_btn.setOnClickListener { changeWord() }

        //TODO: 6. umoznit navigaciu do DatabaseFragmentu po stlaceni tlacidla
    }

    //TODO: 5. odstanit funkciu pomocou databindingu v xml
    private fun changeWord() {
        val word = word_input.text.toString()
        if (word.length > 0) {
            homeViewModel.changeWord(word)
            word_input.text.clear()
        }
    }
}
