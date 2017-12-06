package day5

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/zangardiw/Sandbox/KotlinAdventOfCode2017/src/day5/Day5Input.txt").inputStream()
    val lineList1 = mutableListOf<Int>()
    val lineList2 = mutableListOf<Int>()
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach {
            lineList1.add(it.toInt())
            lineList2.add(it.toInt())
        }
    }
    println("Part one ${partOne(lineList1)}")
    println("Part two ${partTwo(lineList2)}")
}

fun partOne(input: MutableList<Int>): Int {
    var total = 0
    var currentIndex = 0
    while (currentIndex >= 0 && currentIndex < input.size) {
        val jump = input[currentIndex]
        input[currentIndex] = input[currentIndex].inc()
        currentIndex += jump
        total++
    }
    return total
}

fun partTwo(input: MutableList<Int>): Int {
    var total = 0
    var currentIndex = 0
    while (currentIndex >= 0 && currentIndex < input.size) {
        val jump = input[currentIndex]
        if (jump >= 3) {
            input[currentIndex] = input[currentIndex].dec()
        } else {
            input[currentIndex] = input[currentIndex].inc()
        }
        currentIndex += jump
        total++
    }
    return total
}