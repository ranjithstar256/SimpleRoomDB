package kp.ran.simpleroomdb


import androidx.lifecycle.LiveData
import kotlinx.coroutines.runBlocking

class Repository(var dao: TempleDAO) {

 //   val allTemples: LiveData<List<Temple>> = dao.getAllTemples()

    suspend fun insertTemple(temple: Temple){
        runBlocking {
            dao.addTemple(temple)
        }
    }


}