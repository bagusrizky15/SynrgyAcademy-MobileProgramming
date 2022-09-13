package com.example.dasarkotlin

//open class Papa {
//    var ex = "Tes"
//
//    private var name = "Andrea"
//    private var umur = 22
//
//    fun sifat(){
//        println("Saya manusia")
//    }
//
//    fun example() = ex
//}
//
//class Anak: Papa(){
//    private var name = "Jono"
//    private var umur = 8
//}

open class Pegawai {
    internal var nama = ""
    internal var noPegawai = 0
    internal var gaji = 0

    open fun salary() = gaji
}

open class Programmer: Pegawai(){
    var bonus = 0

    override fun salary(): Int {
        return bonus+salary()
    }

    fun pegawai(){
        println("Nama Pegawai : $nama")
        println("No Pegawai : $noPegawai")
        println("Gaji : $gaji")
    }
}

class Manager: Pegawai(){
    var tunjangan = 0

    fun bonus(){
        println("Tunjangan : $tunjangan")
    }

    override fun salary(): Int {
        return tunjangan+salary()
    }
}

fun main(){
//    val x = Anak()
//    x.sifat()
    val programmer = Programmer()
    val manager = Manager()
//    programmer.nama = "Andrea"
//    programmer.noPegawai = 1001
//    programmer.gaji = 8000000
//    programmer.pegawai()
//
//    manager2.nama = "Bagus"
//    manager2.noPegawai = 19112711
//    manager2.pegawai()
//    manager.bonus()

    manager.nama = "Steven"
    manager.gaji = 10000000
    manager.tunjangan = 5000000

    println(manager.salary())


}