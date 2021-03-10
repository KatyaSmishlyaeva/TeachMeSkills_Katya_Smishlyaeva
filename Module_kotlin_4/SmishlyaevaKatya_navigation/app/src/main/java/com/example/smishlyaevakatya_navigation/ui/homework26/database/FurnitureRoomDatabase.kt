package com.example.smishlyaevakatya_navigation.ui.homework26.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.smishlyaevakatya_navigation.ui.homework25.Furniture
import com.example.smishlyaevakatya_navigation.ui.homework26.dao.FurnitureDao

@Database(entities = [Furniture::class], version = 2)
abstract class FurnitureRoomDatabase : RoomDatabase() {

    abstract fun furnitureDao(): FurnitureDao

    companion object {
        @Volatile
        private var INSTANCE: FurnitureRoomDatabase? = null
        fun getDataBase(context: Context): FurnitureRoomDatabase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    FurnitureRoomDatabase::class.java,
                    "furniture_database"
                ).fallbackToDestructiveMigration()
                    .build()
                INSTANCE = instance
                instance
            }
        }
    }
}