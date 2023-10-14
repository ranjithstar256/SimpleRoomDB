package kp.ran.simpleroomdb

import kotlinx.coroutines.runBlocking

class Repository(var dao: TempleDAO) {

    suspend fun insertTemple(temple: Temple){
        runBlocking {
            dao.addTemple(temple)
        }
    }


}