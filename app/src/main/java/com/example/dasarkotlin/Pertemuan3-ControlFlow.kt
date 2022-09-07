package com.example.dasarkotlin

fun main() {

    //Recal Materi kemarin
    var arrayList = mutableListOf("Bagus", 1)
    println(arrayList)
    arrayList.add("Rizky")
    println(arrayList)
    arrayList.removeAt(1)
    println(arrayList)
    arrayList.set(1,"Riska")
    println(arrayList)
    arrayList.add(1,"WKWK")
    println(arrayList)

    //Control Flow
    var a = 2
    var b = 2
    if (a==b)
        println("benar")
    else
        println("salah")

    //komparasi nilai
    val int1 = 10
    val int2 = "10"

    println(int1 == int2.toInt())
    println(int1.equals(int2))

    //fungsi when
    val c = when(b) {
        2 -> "benar"
        else -> "salah"
    }
    println(c)

    //looping
    val range = 0..5
    for (i in range){
        println(i)
    }
}
