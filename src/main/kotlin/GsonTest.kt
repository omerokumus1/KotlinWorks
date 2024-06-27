import com.google.gson.Gson

data class CPID(val uid: String)
fun main() {
    println(Gson().toJson(CPID("ğam")))
}