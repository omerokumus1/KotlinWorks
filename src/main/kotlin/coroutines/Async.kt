package coroutines

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlin.random.Random

fun main() {
    runBlocking {
        val deferred1 = async { f1() }
        val deferred2 = async { f2() }

        println("Processing...")
        delay(500L)
        println("Waiting for values...")

        val v1 = deferred1.await()
        val v2 = deferred2.await()

        println("v1: $v1, v2: $v2")
    }
}

suspend fun f1(): Int {
    delay(1000L)
    val value = Random.nextInt(100)
    println("returning first value $value")
    return value
}

suspend fun f2(): Int {
    delay(2000L)
    val value = Random.nextInt(100)
    println("returning second value $value")
    return value
}

