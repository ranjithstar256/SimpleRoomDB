package kp.ran.simpleroomdb

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.runBlocking

class TempleViewModel(var repository: Repository) : ViewModel() {

    suspend fun insert(temple: Temple){
        repository.insertTemple(temple)
    }
}