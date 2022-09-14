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


fun main(){
   // piramidaBintang()
    piramidaTerbalikBintang()
}