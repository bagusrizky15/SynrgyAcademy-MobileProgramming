package com.example.dasarkotlin

class vehicle{

    var name: String? = null
    var model: String? = null
    var typeFuel: String? = null

    constructor(name: String?, model: String?=null, _typeFuel:String?=null){
        this.name = name
        this.model = model
        typeFuel = _typeFuel
    }
}

fun main(){
    val car = vehicle(name = "Johnson")
//    car.name = "Avanza"
    print(car.name)
}