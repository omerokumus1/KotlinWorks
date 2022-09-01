/**
 * Sealed class vs Enum class vs Sealed interface
 *      - Sealed class creates some kind of constant objects while Enum class creates constant variables.
 *      - Since sealed class provides objects, it also provides more customization.
 *      - If you really have variables, then use Enum class. However, if you want to put more customization, then use
 *          sealed class.
 *
 *      - If sealed class has no constructor argument, make it sealed interface so that you can save some code
 *
 *      - All enum class instances are known at compile time. So, you can reach them all by values() method.
 */

/** Example 1- sealed class equals to the enum class because subclasses of sealed class have the same field*/
sealed class HttpError(val code: Int){
    object Unauthorized: HttpError(401)
    object NotFound: HttpError(404)

    fun f1(){

    }
//    abstract fun f2() // allowed
}

enum class HttpErrorEnum(val code: Int){
    Unauthorized(401),
    NotFound(404);

    fun f(){

    }
}

/** Example 2- sealed class does not equal to the enum class because subclasses of sealed class do not have the same field.
 *  Different customization needed here */
sealed class HttpError2(val code: Int) {
    data class Unauthorized(val reason: String): HttpError2(401)
    object NotFound: HttpError2(404)
}

fun main() {
    val error: HttpError = HttpError.NotFound
    when (error) {
        HttpError.Unauthorized -> println("HttpError.Unauthorized")
        is HttpError.NotFound -> println("is HttpError.NotFound")
    }
    val error2: HttpError2 = HttpError2.Unauthorized("reason")
    when(error2){
        HttpError2.NotFound -> println("HttpError2.NotFound") // since NotFound is an object, no 'is' required
        is HttpError2.Unauthorized -> println("HttpError2.Unauthorized") // since Unauthorized is a data class, 'is' required
    }
    val errorNum: HttpErrorEnum = HttpErrorEnum.NotFound
    when(errorNum){
        HttpErrorEnum.NotFound -> println("HttpErrorEnum.NotFound")
        HttpErrorEnum.Unauthorized -> println("HttpErrorEnum.Unauthorized")
    }
}

/** Sealed Interface */
sealed interface HttpError3 {
    data class Unauthorized(val reason: String): HttpError3
    object NotFound: HttpError3
}