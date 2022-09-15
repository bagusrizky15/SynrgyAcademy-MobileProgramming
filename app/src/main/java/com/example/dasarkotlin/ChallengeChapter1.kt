package com.example.dasarkotlin

//nomor 1
fun piramidaBintang(){
    var n = 8
    for(i in 0 until n){
        for(j in 0 until n-i){
            print(" ")
        }
        for(k in 0 until i){
            print("* ")
        }
        println("")
    }
}

//nomor 2
fun piramidaTerbalikBintang(){
    var n = 8
    for (i in n downTo 1) {

        for (k in 1..n - i) {
            print("  ")
        }

        for (j in i..2 * i - 1) {
            print("* ")
        }

        for (j in 0..i - 1 - 1) {
            print("* ")
        }

        println()
    }
}

//nomor 3
fun layangBintang(){
    var n = 8
//    for(i in 0 until n){
//        for(j in 0 until n-i){
//            print(" ")
//        }
//        for(k in 0 until i){
//            print("* ")
//        }
//        println("")
//    }
    for (i in n downTo 1) {


        for (j in 0..i - 1 - 1) {
            print("ab")
        }

//        for (j in i..2 * i - 1) {
//            print("*=")
//        }
//
//        for (k in 1..n - i) {
//            print("xd")
//        }

        println()
    }

    for (i in n downTo 1) {

        for (k in 1..n - i) {
            print("  ")
        }

        for (j in i..2 * i - 1) {
            print("* ")
        }

        for (j in 0..i - 1 - 1) {
            print("* ")
        }

        println()
    }
}


fun main(){
   // piramidaBintang()
    //piramidaTerbalikBintang()
    layangBintang()
}