package coroutines

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    runBlocking {
        val job1 = launch {
            println("Job1 launched")
        }

        job1.invokeOnCompletion { println("job1.invokeOnCompletion") }

        val job2 = GlobalScope.launch {
            val job3 = launch {

            }
        }

    }
}