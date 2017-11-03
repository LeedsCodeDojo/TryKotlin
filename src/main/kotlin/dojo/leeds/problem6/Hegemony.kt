package dojo.leeds.problem6

fun hegemony(input: String): Double {
    val heights = input.split(" ").map { it.toDouble() }
    return (1..(heights.size-2))
            .fold(heights[0], { previousHeight,index -> minOf( heights[index], (previousHeight + heights[index+1])/2.0)})
}

