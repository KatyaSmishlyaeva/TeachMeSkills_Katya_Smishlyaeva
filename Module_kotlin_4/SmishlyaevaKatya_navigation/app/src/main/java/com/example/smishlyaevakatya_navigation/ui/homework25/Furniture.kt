package com.example.smishlyaevakatya_navigation.ui.homework25

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Parcelize
@Entity(tableName = "furniture_table")
data class Furniture(
    @PrimaryKey
    @ColumnInfo(name = "info")
    val name: String,
    @ColumnInfo(name = "image")
    val image: String,
    @ColumnInfo(name = "stock")
    val isInStock: String
) : Parcelable