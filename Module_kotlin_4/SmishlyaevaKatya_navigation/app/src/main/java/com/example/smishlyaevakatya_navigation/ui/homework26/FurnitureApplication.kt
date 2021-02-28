package com.example.smishlyaevakatya_navigation.ui.homework26

import android.app.Application
import com.example.smishlyaevakatya_navigation.ui.homework26.database.FurnitureRoomDatabase
import com.example.smishlyaevakatya_navigation.ui.homework26.repository.FurnitureRepository

class FurnitureApplication : Application() {
    val database by lazy {
        FurnitureRoomDatabase.getDataBase(this)
    }

    val repository by lazy {
        FurnitureRepository(database.furnitureDao())
    }
}