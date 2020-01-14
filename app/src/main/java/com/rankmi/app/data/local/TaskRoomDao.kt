package com.rankmi.app.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query

@Dao
interface TaskRoomDao {

    @Query("SELECT * from tasks")
    fun getAll(): LiveData<List<TaskEntity>>

    @Insert(onConflict = REPLACE)
    fun insert(weatherData: TaskEntity)

    @Query("DELETE from tasks")
    fun deleteAll()
}