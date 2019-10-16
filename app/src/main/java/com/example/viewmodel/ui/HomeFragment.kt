package com.example.viewmodel.ui


import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.lifecycle.observe
import com.example.viewmodel.R
import com.example.viewmodel.databinding.FragmentHomeBinding
import com.example.viewmodel.ui.viewModels.HomeViewModel
import com.opinyour.android.app.data.utils.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {
    private lateinit var homeViewModel: HomeViewModel
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentHomeBinding>(
            inflater, R.layout.fragment_home, container, false
        )
        binding.lifecycleOwner = this

        homeViewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.model = homeViewModel

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        word_btn.setOnClickListener { changeWord() }
    }

    private fun changeWord() {
        val word = word_input.text.toString()
        if (word.length > 0) {
            homeViewModel.changeWord(word)
            word_input.text.clear()
        }
    }
}
