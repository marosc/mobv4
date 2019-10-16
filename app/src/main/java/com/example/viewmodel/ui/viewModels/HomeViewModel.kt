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
    val input: MutableLiveData<String> = MutableLiveData()

    private val _word: MutableLiveData<String> = MutableLiveData()

    val word: LiveData<String>
        get() = _word


    fun changeWord() {
        _word.postValue(input.value)
    }

}
