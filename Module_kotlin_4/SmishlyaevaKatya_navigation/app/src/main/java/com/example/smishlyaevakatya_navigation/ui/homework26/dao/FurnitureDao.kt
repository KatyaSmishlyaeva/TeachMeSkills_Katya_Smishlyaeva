package com.example.smishlyaevakatya_navigation.ui.homework26.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.example.smishlyaevakatya_navigation.ui.homework25.Furniture

@Dao
interface FurnitureDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addFurniture(furniture: Furniture)

    @Query("SELECT * FROM furniture_table ORDER BY info ASC")
    fun getFurniture(): LiveData<List<Furniture>>

    @Delete
    fun deleteFurniture(furniture: Furniture)
}