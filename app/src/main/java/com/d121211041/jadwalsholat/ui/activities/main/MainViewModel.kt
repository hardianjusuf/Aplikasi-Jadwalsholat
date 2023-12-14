package com.d121211041.jadwalsholat.ui.activities.main

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.D121211041.jadwalsholat.data.models.Jadwal
import com.d121211041.jadwalsholat.MyApplication
import com.d121211041.jadwalsholat.data.repository.JadwalsholatRepository
import kotlinx.coroutines.launch
import java.io.IOException

sealed interface MainUiState {
    data class Success(val jadwalsholat: List<Jadwal?>) : MainUiState
    object Error : MainUiState
    object Loading : MainUiState
}

class MainViewModel(private val jadwalsholatRepository: JadwalsholatRepository): ViewModel() {

    // initial state
    var mainUiState: MainUiState by mutableStateOf(MainUiState.Loading)
        private set

    fun getJadwalsholat() = viewModelScope.launch {
        mainUiState = MainUiState.Loading
        try {
            val result = jadwalsholatRepository.getJadwalsholat()

            if (result.status) {
                val jadwalList = result.data.jadwal
                mainUiState = MainUiState.Success(jadwalList.orEmpty())
            } else {
                // Handle case where status is false, for example, show an error message
                mainUiState = MainUiState.Error
            }
        } catch (e: IOException) {
            mainUiState = MainUiState.Error
        }
    }

    // block yg prtama dipanggil ktika ini dibuka
    init {
        getJadwalsholat()
    }

    companion object {
        val Factory: ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application =
                    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as MyApplication)
                val jadwalsholatRepository = application.container.jadwalsholatRepository
                MainViewModel(jadwalsholatRepository)
            }
        }
    }
}