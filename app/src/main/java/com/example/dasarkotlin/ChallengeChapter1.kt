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
    val rowsUp = 4
    val rowsDown = 3
    var k = 0

    for (i in 1..rowsUp) {
        for (space in 1..rowsUp - i) {
            print("  ")
        }

        while (k != 2 * i - 1) {
            print("* ")
            ++k
        }

        println()
        k = 0
    }

    for (i in rowsDown downTo 1) {

        for (space in 0..rowsDown - i) {
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

//nomor 4
fun xBintang(){

}

fun main(){
   // piramidaBintang()
    //piramidaTerbalikBintang()
   // layangBintang()
    xBintang()
}