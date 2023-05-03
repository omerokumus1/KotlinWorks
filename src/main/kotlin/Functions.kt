fun main() {


    fun applyOp(x: Int, y: Int, op: (Int, Int) -> Int): Int = op(x, y)

//    val sum: (Int, Int) -> Int = { x, y -> x + y }

    fun sum(x: Int, y: Int) = x + y

    println(applyOp(2, 3, ::sum))

    val str = "test"

    // from
    str.let { println(it) }
    // to
    str.let(::println)

    str.let(::ifNull)
    str.let(::listOf)
//    str.let(::sum)

    val items = listOf(
        MediaItem("t1", "u1"),
        MediaItem("t2", "u2"),
        MediaItem("t3", "u3"),
    )

    // from
    items.sortedBy { it.title }
    // to
    items.sortedBy(MediaItem::title)



    items.map(MediaItem::url)
    items.forEach(::println)

    items.map { it.url }
    items.forEach { println(it) }

}

data class MediaItem(val title: String, val url: String)