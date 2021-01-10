package com.example.jumpingcat

class Cat(val name: String, var weight: Int, val color: String, var height: Int, var length: Int) {

    val power: Int
        get() = weight * height * length

    fun jumpHeight(): Int {
        return weight * height * length / 200
    }
}