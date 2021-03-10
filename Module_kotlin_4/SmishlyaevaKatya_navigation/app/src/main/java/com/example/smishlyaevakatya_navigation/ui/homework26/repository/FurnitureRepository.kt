package com.example.smishlyaevakatya_navigation.ui.homework26.repository

import androidx.lifecycle.LiveData
import com.example.smishlyaevakatya_navigation.ui.homework25.Furniture
import com.example.smishlyaevakatya_navigation.ui.homework26.dao.FurnitureDao

class FurnitureRepository(private val furnitureDao: FurnitureDao) {

    val allFurniture: LiveData<List<Furniture>> = furnitureDao.getFurniture()

    suspend fun addFurniture(furniture: Furniture) {
        furnitureDao.addFurniture(furniture)
    }

    fun deleteFurniture(furniture: Furniture) {
        furnitureDao.deleteFurniture(furniture)
    }
}