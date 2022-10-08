infix fun String.to(type: String): String {
    if(type=="besar")
    {
        return this.toUpperCase()
    }else {
        return this.toLowerCase()
    }
} 

fun main(){
    val namasaya = "Bagus" to "besar"
    print(namasaya)
} 