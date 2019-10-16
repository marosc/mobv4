package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HomeViewModel : ViewModel() {
    //TODO: 3. urobit enkapsulaciu premennej word
    val word: MutableLiveData<String> = MutableLiveData()

    //TODO: 4. urobit obojsmerny binding pre edittext

    //TODO: 5. nahradit listener databindingom v xml
    fun changeWord(word: String) {
        this.word.postValue(word)
    }

    //TODO: 6b.urobit transformaciu slova aby sa zobrazoval text "Slovo je: "
}
