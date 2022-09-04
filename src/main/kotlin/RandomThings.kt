fun main() {
    // execute statement if null
    val values = mapOf<Any, Any>()
    val email = values["email"] ?: ifNull("Email")
    println(email)

    // fallback value with run
    val files = getFiles()
    val someSize = 0

    val filesSize = files?.size ?: run {
        val size1 = getFileSize(1)
        val size2 = getFileSize(2)
        val size3 = getFileSize(3)
        val guessedFileSize = size1 + size2 + size3
        guessedFileSize
    }
    println(filesSize)

}

fun getFileSize(i: Int): Int {
    return 1
}

fun getFiles(): List<Any>? {
    return null
}

fun ifNull(value: String): String {
    return "$value is missing"
}