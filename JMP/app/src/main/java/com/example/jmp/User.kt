package com.example.jmp

class User {

    var id: Int=0
    var nama: String = ""
    var alamat: String=""
    var nomor: String=""
    var lokasi: String=""
    var foto: String=""

    constructor(nama:String, alamat:String, nomor:String, lokasi:String, foto:String){
        this.nama = nama
        this.alamat =alamat
        this.nomor=nomor
        this.lokasi=lokasi
        this.foto=foto
    }
}