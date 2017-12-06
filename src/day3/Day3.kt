package day3

import java.lang.Math.*

fun main(args: Array<String>) {
    println("Part one ${partOne()}")
}

fun partOne(): String {
    val input = 9
    val dimensions = ceil(sqrt(input.toDouble()))
    val center = floor(sqrt(dimensions)).toInt()
    var currentX = center
    var currentY = center
    var graph = Array(dimensions.toInt()) { IntArray(dimensions.toInt()) }
    for (i in 1..input) {
//        val right = graph[currentX + 1][currentY]
//        var up = graph[currentX][currentY - 1]
//        var left = graph[currentX - 1][currentY]
//        var down = graph[currentX][currentY + 1]
        if(graph[currentX][currentY] == 0) {
            graph[currentX][currentY] = i
        }
        println("${sqrt(i.toDouble())}")
    }
//    graph[center][center] = 1
//    graph.forEach{ value ->
//        value.forEach{ value2 ->
//            println(value2)
//        }
//    }
    return "$dimensions x $dimensions"
}