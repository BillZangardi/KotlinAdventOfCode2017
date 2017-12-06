package day4

import java.io.File
import java.io.InputStream


fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/zangardiw/Sandbox/KotlinAdventOfCode2017/src/day4/Day4Input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    println("Part one ${partOne(inputString)}")
    println("Part two ${partTwo(inputString)}")
}

fun partOne(input: String): Int {
    var total = 0;
    input.split('\n').forEach line@ { password ->
        password.split(' ').forEachIndexed word@ { passwordIndex, word ->
            val row = password.split(' ')
            (0 until row.size)
                    .filter { passwordIndex != it && word == row[it] }
                    .forEach { return@line }
        }
        total++
    }
    return total
}

fun partTwo(input: String): Int {
    var total = 0;
    input.split('\n').forEach line@ { password ->
        password.split(' ').forEachIndexed word@ { passwordIndex, word ->
            val row = password.split(' ')
            (0 until row.size)
                    .filter { passwordIndex != it && word.length == row[it].length }
                    .forEach {
                        if (word == row[it]) {
                            return@line
                        }
                        var temp = row[it]
                        word.split("").forEach { letter ->
                            if (temp.contains(letter)) {
                                temp = temp.replaceFirst(letter, "")
                            }
                        }
                        if (temp.isEmpty()) {
                            return@line
                        }
                    }
        }
        total++
    }
    return total
}