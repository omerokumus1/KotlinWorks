package coroutines

import kotlinx.coroutines.*

fun main() {
    println("Program execution will now blocked")
    runBlocking {
        launch {
            delay(1000L)
            println("Task from runBlocking")
        }

        GlobalScope.launch {
            delay(500L)
            println("Task from GlobalScope")
        }



        coroutineScope {
            launch {
                delay(1500L)
                println("Task from coroutineScope")
            }
        }

        var coroutineScope = CoroutineScope(Dispatchers.Main)
        coroutineScope.launch {
            println("loading..")
            delay(3000)
            println("job is done")
        }


    }
    println("Program execution will now continue")
}