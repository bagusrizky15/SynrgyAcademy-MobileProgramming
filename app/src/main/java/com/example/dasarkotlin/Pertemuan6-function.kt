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

//pangkat ekstension
fun Double.pkt(pangkat: Int) Int{
    var res =1.0
    for (i in 1 until pangkat){
        res *= this
    }
    return res.roundToInt()
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

    val pangkatA: (Int, Int) -> Int = {angkaQ,y ->
        var angkaP = angkaQ
        for (i in 1 until y){
            angkaP *= angkaQ
        }
        return angkaP
    }
}