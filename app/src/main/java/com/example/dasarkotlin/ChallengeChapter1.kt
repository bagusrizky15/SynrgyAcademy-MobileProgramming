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
    for(i in n until 0){
        for(j in 0 until n-i){
            print(" ")
        }
        for(k in n until i-1-1){
            print("* ")
        }
        println("")
    }
}


fun main(){
   // piramidaBintang()
    piramidaTerbalikBintang()
}