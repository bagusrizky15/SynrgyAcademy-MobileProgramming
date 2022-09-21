package com.example.dasarkotlin

abstract class Shape{
    abstract fun area(): Int
}

class Rectangle(var width: Int, var height: Int): Shape(){
    override fun area(): Int {
        return width*height
    }
}

class Square(var edge: Int): Shape(){
    override fun area(): Int {
        return edge*edge
    }
}

fun main(){

}