package dojo.leeds.problem4

import java.util.*
import kotlin.streams.toList

fun main(args: Array<String>) {
    val rnd = Random()

    fun generateMark(average: Int, sd: Int, minMark: Int= 0, maxMark:Int=100) : Int {
        return (average + sd * rnd.nextGaussian())
                .toInt()
                .coerceIn(minMark,maxMark)
    }

    @Suppress("JAVA_CLASS_ON_COMPANION")
    fun readNames(fileName: String): List<String>{
        return String.javaClass.classLoader.getResourceAsStream(fileName)
                .bufferedReader().lines()
                .toList()
    }

    val boysNames = readNames("boysNames.txt")
    val girlsNames = readNames("girlsNames.txt")

    println(listOf("Name","Gender","Class","English","Maths", "Science").joinToString())
    (0..120).forEach {
        val (name,gender) = when (rnd.nextBoolean()){
            true -> Pair(boysNames[rnd.nextInt(boysNames.size)],"M")
            false -> Pair(girlsNames[rnd.nextInt(girlsNames.size)],"F")
        }
        val className = "Class %d".format(rnd.nextInt(5)+1)
        val (english, maths,science) = (1..3)
                .map { generateMark(65,15) }
                .map { it.toString() }
        println(listOf(name,gender, className, english, maths,science).joinToString())
    }
}
