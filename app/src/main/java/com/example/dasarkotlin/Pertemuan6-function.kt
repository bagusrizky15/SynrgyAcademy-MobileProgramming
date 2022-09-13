package com.example.dasarkotlin

import kotlin.math.roundToInt

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

//pangkat
fun pangkat(x: Int, y:Int): Int {
    var angka=x
    for (i in 1 until y){
        angka *= x
    }
    return angka
}

fun main(){

    println(pangkat(3,2))

    //penggunan lambda
    var penjumlahan: (Int, Int) -> Int = {a,b -> a+b}

    println(penjumlahan(1,3))
    println(perkalian(2,3))
    println(1.toHuruf())
    3.toHuruf()

    Vehicle.RODA
    Vehicle.caraBergerak()

    println(Vehicle.RODA)

}