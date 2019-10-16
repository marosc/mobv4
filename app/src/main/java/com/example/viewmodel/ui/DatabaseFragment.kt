package com.example.viewmodel.ui


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import com.example.viewmodel.R
import com.example.viewmodel.ui.viewModels.DatabaseViewModel
import com.opinyour.android.app.data.utils.Injection
import kotlinx.android.synthetic.main.fragment_database.*


class DatabaseFragment : Fragment() {
    private lateinit var databaseViewModel: DatabaseViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_database, container, false)

        //TODO: 7. prerobit na databinding
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        databaseViewModel = ViewModelProvider(this, Injection.provideViewModelFactory(context!!))
            .get(DatabaseViewModel::class.java)

        //TODO: 8. nahradit observer databindingom v xml
        databaseViewModel.words.observe(this) { words_text.text = it.toString() }

        //TODO: 10. nahradit listener databindingom v xml
        word_btn.setOnClickListener { addWord() }
    }

    //TODO: 10. odstanit funkciu pomocou databindingu v xml
    private fun addWord() {
        val word = word_input.text.toString()
        if (word.length > 0) {
            databaseViewModel.insertWord(word)
            word_input.text.clear()
        }
    }
}
