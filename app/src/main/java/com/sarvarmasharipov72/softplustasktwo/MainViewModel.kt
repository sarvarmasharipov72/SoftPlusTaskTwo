package com.sarvarmasharipov72.softplustasktwo

import androidx.lifecycle.*
import com.sarvarmasharipov72.softplustasktwo.data.Repository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainViewModel constructor(private val repository: Repository) : ViewModel() {

    var toast = MutableLiveData<String>()

    fun getCounter() {
        viewModelScope.launch {
            if (repository.getCounter() == 3) {
                toast.value = "This app 3 start"
            }
        }
    }
}

class MainViewModelFactory @Inject constructor(private val repository: Repository) :
    ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(repository = repository) as T
    }
}