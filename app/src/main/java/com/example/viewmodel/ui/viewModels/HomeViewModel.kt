package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.viewmodel.data.DataRepository
import com.example.viewmodel.data.db.model.VideoItem
import com.example.viewmodel.data.db.model.WordItem
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    val word: MutableLiveData<String> = MutableLiveData()


    fun changeWord(word: String) {
        this.word.postValue(word)
    }

}
