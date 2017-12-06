package day4

import java.io.File
import java.io.InputStream


fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/zangardiw/Sandbox/KotlinAdventOfCode2017/src/day4/Day4Input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    println("Part one ${partOne(inputString)}")
    println("Part two ${partTwo()}")
}

fun partOne(input: String): Int {
    var total = 0;
    input.split('\n').forEachIndexed line@ { index, password ->
        password.split(' ').forEachIndexed word@ { passwordIndex, word ->
            (0 until password.split(' ').size)
                    .filter { passwordIndex != it && word == password.split(' ')[it] }
                    .forEach { return@line }
        }
        total++
    }
    return total
}

fun partTwo(): Int {
    return 0
}