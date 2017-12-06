package day3

import java.lang.Math.*

fun main(args: Array<String>) {
    println("Part one ${partOne()}")
}

fun partOne(): String {
    val input = 25
    val dimensions = ceil(sqrt(input.toDouble()))
    val center = floor(sqrt(dimensions)).toInt()
    var currentX = center
    var currentY = center
    var graph = Array(dimensions.toInt()) {
        IntArray(dimensions.toInt())
    }
    var currentSquareDiameter = 1
    for (i in 1..input) {
        if(currentX >=0 && currentY >= 0) {
            graph[currentY][currentX] = i
            if (i % 2 != 0 && i * i == currentSquareDiameter) {
                currentX++
                currentSquareDiameter++
            } else if (i == currentSquareDiameter) {
                currentY--
            } else if (i == currentSquareDiameter * currentSquareDiameter + 1) {
                currentY++
                currentSquareDiameter++
            } else {
                currentX--
            }
        }
    }
    graph.forEach { value ->
        value.forEach { value2 ->
            print("$value2\t")
        }
        print("\n")
    }
    return "$dimensions x $dimensions"
}

fun isPrime(num: Int): Boolean {
    val flag = (2..num / 2).any { num % it == 0 }
    return !flag
}