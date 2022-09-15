package com.example.dasarkotlin

fun ArrayChallenge(arr: Array<Int>){
    var tmp = 0
    // write your code here
    for (i in arr)
        tmp = i - (i + 1)
}

fun main() {
    println(ArrayChallenge(readLine1()))
}

//input 1
fun readLine1(): Array<Int> = arrayOf(44, 30, 24, 32, 35, 30, 40, 38, 15)

//input 2
fun readLine2(): Array<Int> = arrayOf(10, 9, 8, 2)