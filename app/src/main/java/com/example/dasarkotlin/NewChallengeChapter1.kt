package com.example.dasarkotlin
import android.os.Build
import androidx.annotation.RequiresApi
import kotlin.collections.HashMap

//nomor 1
fun ArrayChallenge(arr: Array<Int>): Int{
    var hasil:Int = 0
    for (i in arr.indices) {
        for (j in arr.indices){
           hasil = arr[j+1] - arr[i]
            if (hasil>arr[j+1] - arr[i]){
                hasil = arr[j+1] - arr[i]
            }else{
                return -1
            }
        }
    }
    return hasil
}

//nomor 2
fun formatNumber(phone: String): String {
    var hasil = phone.replace(("[^\\w\\d ]").toRegex(), "").replace("\\s".toRegex(), "")
    if (hasil[0] == '0'){
        hasil = hasil.replaceRange(0,1, "62")
    }
    return hasil
}

//nomor 3
@RequiresApi(Build.VERSION_CODES.N)
fun isAnagram(a: String, b: String): Boolean {
    if (a.length != b.length){
        return false
    }

    val map = HashMap<Char, Int>()

    val strArrA = a.toCharArray()
    val strArrB = b.toCharArray()

    for (c in strArrA) map[c] = map.getOrDefault(c, 0) + 1

    for (c in strArrB){
        var current = map.getOrDefault(c, 0)
        if(current < 1) return false
        map[c] = --current
    }

    return true
}

@RequiresApi(Build.VERSION_CODES.N)
fun main() {
    println("NOMOR 1")
    println(ArrayChallenge(readLine1()))
    println(ArrayChallenge(readLine2()))

//    println("NOMOR 2")
//    println(formatNumber(readLineA()))
//    println(formatNumber(readLineB()))
//    println(formatNumber(readLineC()))
//
//    println("NOMOR 3")
//    println(isAnagram("mycar", "camry"))
//    println(isAnagram("Hello", "hello"))
//    println(isAnagram("anagram", "margana"))
//    println(isAnagram("Raden", "Denah"))
}

//input 1
fun readLine1(): Array<Int> = arrayOf(44, 30, 24, 32, 35, 30, 40, 38, 15)

//input 2
fun readLine2(): Array<Int> = arrayOf(10, 9, 8, 2)

//input 1
fun readLineA() = "0851-6231-7243"

//input 2
fun readLineB() = "0877 6431 7123"

//input 3
fun readLineC() = "+62877 6294 2312"