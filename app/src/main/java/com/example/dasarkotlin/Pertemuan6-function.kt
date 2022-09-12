package com.example.dasarkotlin

// contoh function
fun perkalian (x: Int, y:Int): Int {
    val z = x*y
    return z
}

//contoh extension
fun Int.toHuruf(){
    if (this.equals(0)){
        print("Nol")
    }else if (this.equals(1)){
        print("Satu")
    }else {
        print("lebih dari 1")
    }
}

class Vehicle{
    companion object {
        var RODA = 4
        fun caraBergerak() = "bergerak maju kedepan"
    }
}

fun main(){
    println(perkalian(2,3))
    println(1.toHuruf())
    3.toHuruf()

    Vehicle.RODA
    Vehicle.caraBergerak()

    println(Vehicle.RODA)
}