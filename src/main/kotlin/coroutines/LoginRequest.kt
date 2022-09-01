package coroutines

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
    runBlocking {
        launch(Dispatchers.IO) {
            println(makeLoginRequest())
        }

        println(makeLoginRequest2())
    }
}

fun makeLoginRequest(): String {
    return "login request is successful"
}

suspend fun makeLoginRequest2(): String {
    return withContext(Dispatchers.IO) {
        val r = "login is successful "
        r + "2"
    }
}