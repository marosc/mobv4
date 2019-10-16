package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.data.db.model.WordItem
import kotlinx.coroutines.launch

class DatabaseViewModel(private val repository: DataRepository) : ViewModel() {

    val words: LiveData<List<WordItem>>
        get() = repository.getWords()

    //TODO: 8. nahradit observer databindingom v xml

    //TODO: 9. urobit obojsmerny binding pre edittext

    //TODO: 10. nahradit listener databindingom v xml
    fun insertWord(word: String) {
        viewModelScope.launch { repository.insertWord(WordItem(word)) }
    }
}
