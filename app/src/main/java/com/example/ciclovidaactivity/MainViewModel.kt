package com.example.ciclovidaactivity


import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel

class MainViewModel(private val state: SavedStateHandle): ViewModel() {
    private val mContador = MutableLiveData(state["count"] ?: 0)
    val contador: LiveData<Int>
        get() =  mContador

    fun addNumber() {
        mContador.value = mContador.value!! + 1
        state["count"] = mContador.value
    }
}
