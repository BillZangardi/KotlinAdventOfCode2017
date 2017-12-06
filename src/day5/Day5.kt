package day5

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/zangardiw/Sandbox/KotlinAdventOfCode2017/src/day5/Day5Input.txt").inputStream()
    val lineList = mutableListOf<Int>()
    inputStream.bufferedReader().useLines { lines -> lines.forEach { lineList.add(it.toInt()) } }
    println("Part one ${partOne(lineList)}")
    println("Part two ${partTwo(lineList)}")
}

fun partOne(input: MutableList<Int>): Int {
    var total = 0
    var currentIndex = 0
    while (currentIndex < input.size) {
        var jump = input[currentIndex]
        input[currentIndex] = input[currentIndex] + 1
        currentIndex += jump
        total++
    }
    return total
}

fun partTwo(input: MutableList<Int>): Int {
    var total = 0
    return total
}