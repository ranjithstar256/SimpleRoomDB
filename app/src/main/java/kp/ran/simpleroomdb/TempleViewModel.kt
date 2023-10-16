package kp.ran.simpleroomdb

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject



@HiltViewModel
class TempleViewModel @Inject constructor (var repository: Repository) : ViewModel() {

    suspend fun insert(temple: Temple){

        viewModelScope.launch {
            repository.insertTemple(temple)

        }
    }
}