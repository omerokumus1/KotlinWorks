package scope_functions

class LetFunction {
    private var v1: Int? = null
    private val v3: Int? = null

    fun ifNullCheck() {
        if (v1 != null) {
//            var v2 = v1 + 1
        }

        if (v3 != null) {
            var v2 = v3 + 1
        }
    }

    fun letFunc() {
        val x = v1?.let {
            it + 1
        }
        println("x: $x")
    }

    fun alsoFunc() {
        val p = Point(2, 3)
        val y = p.also {
            p.x = 3
        }
        println("y: (${y.x}, ${y.y})")

        var x = 5
        val z = x.also {
            x += 1
        }
        println("z: $z")
    }
}

class Point(var x: Int, var y: Int)

fun main() {
    val lf = LetFunction()
    lf.alsoFunc()
}