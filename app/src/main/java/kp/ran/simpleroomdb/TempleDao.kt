package kp.ran.simpleroomdb

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update

@Dao
interface TempleDAO {

   /* @Query("SELECT * FROM TEMPLE")
    fun getAllTemples(): LiveData<List<Temple>>
*/
    @Insert
    suspend fun addTemple(temple: Temple)

  /*  @Query("SELECT * from Temple")
    suspend fun getAllTemple(): List<Temple>
*/
    /*@Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(temple: Temple)

    @Update
    suspend fun update(temple: Temple)

    @Delete
    suspend fun delete(temple: Temple)
*/
/*    @Query("SELECT TempleName FROM temple where MainGod like :namex")
    suspend fun getloc(namex:String)*/

    /*  @Query("SELECT location FROM Students WHERE name LIKE :namex")
      suspend fun getloc(namex: String): String?
      //@Query("select * from Students where name like name")

      @Query("SELECT id FROM Students where name = :itm")
      suspend fun getId(itm:String):Int


  */
}