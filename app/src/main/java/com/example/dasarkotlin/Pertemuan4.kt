package com.example.dasarkotlin

fun main(){
//for (angka in 1..5) {
//    println(angka)
//    if (angka % 2 == 0) {
//        continue
//    }
//}

//    var nama = arrayListOf<String>("Andre", "Kelas", "Android")
//    nama.set(2, "Pemrograman Kotlin")
//    println(nama)
//
//    for (i in nama.indices) {
//        if (nama[i] == "Andre")
//        nama.set(i, "Kiki")
//    }
//    println(nama)

    //Looping

//    var i = 0
//    while (i<=5)
//        println(++i)
//
//    println()
//    var j = 0
//    while (j<=5)
//        println(j++)

//    val rows = 5
//    var k = 0
//
//    for (i in 1..rows) {
//        for (space in 1..rows - i) {
//            print("  ")
//        }
//
//        while (k != 2 * i - 1) {
//            print("* ")
//            ++k
//        }
//
//        println()
//        k = 0
//
//    }

//    for (i in 0..4) {
//
//        for (spc in 0..i){
//            print(" ")
//        }
//
//        for (j in 0..4) {
//            print("*")
//        }
//        println()
//
//    }

    for (i in 0..4) {
        for (spc in i..4){
            print(" ")
        }
        for (j in 1..i) {
            print("*")
        }
        println()
    }


}