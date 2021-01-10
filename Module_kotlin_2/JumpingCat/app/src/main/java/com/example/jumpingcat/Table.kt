package com.example.jumpingcat

class Table(height: Int, color: String, material: String, length: Int) :
    Furniture(height, color, material, length) {
    val countOfTableLegs: Int = 4
}