package com.example.viewmodel.ui.viewModels


import androidx.lifecycle.*

class HomeViewModel : ViewModel() {
    val input: MutableLiveData<String> = MutableLiveData()

    private val _word: MutableLiveData<String> = MutableLiveData()

    val welcome = Transformations.map(word) { w -> "Words is: $w" }

    val word: LiveData<String>
        get() = _word

    fun changeWord() {
        input.value?.apply {
            if (length > 0) {
                _word.postValue(this)
            }
        }
    }

}
