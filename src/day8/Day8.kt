package day8

import java.io.File
import java.io.InputStream

const val REGISTER = 0
const val MODIFY = 1
const val AMOUNT = 2
const val CONDIOTIONAL_A = 4
const val CONDIOTIONAL_TYPE = 5
const val CONDIOTIONAL_B = 6
const val INC = "inc"
const val DEC = "dec"
const val LESS_THAN = "<"
const val GREATER_THAN = ">"
const val LESS_THAN_OR_EQUAL = "<="
const val GREATER_THAN_OR_EQUAL = ">="
const val EQUAL = "=="
const val NOT_EQUAL = "!="

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/zangardiw/Sandbox/KotlinAdventOfCode2017/src/day8/Day8Input.txt").inputStream()
    val inputString = inputStream.bufferedReader().use { it.readText() }
    var largestEver = 0
    val cells: HashMap<String, Int> = hashMapOf()
    inputString.split("\n").forEach line@ { line ->
        var currentCell = ""
        var modifier = ""
        var modifyAmount = 0
        var firstConditional = ""
        var type = ""
        var secondConditional = 0
        line.split(" ").forEachIndexed { wordIndex, s ->
            when (wordIndex) {
                REGISTER -> currentCell = s
                MODIFY -> modifier = s
                AMOUNT -> modifyAmount = s.toInt()
                CONDIOTIONAL_A -> firstConditional = s
                CONDIOTIONAL_TYPE -> type = s
                CONDIOTIONAL_B -> secondConditional = s.toInt()
            }
        }
        if (!cells.containsKey(currentCell)) {
            cells.put(currentCell, 0)
        }
        if (!cells.containsKey(firstConditional)) {
            cells.put(firstConditional, 0)
        }
        if (conditionalIsCorrect(cells[firstConditional]!!, type, secondConditional)) {
            when (modifier) {
                INC -> {
                    cells.put(currentCell, cells[currentCell]!! + modifyAmount)
                }
                DEC -> {
                    cells.put(currentCell, cells[currentCell]!! - modifyAmount)
                }
            }
        }
        if (cells[currentCell]!! > largestEver) {
            largestEver = cells[currentCell]!!
        }
    }
    var currentLargest = 0
    cells.forEach { _, value ->
        if (value > currentLargest) {
            currentLargest = value
        }
    }
    println("Part one $currentLargest")
    println("Part two $largestEver")
}

fun conditionalIsCorrect(i: Int, type: String, secondConditional: Int): Boolean {
    when (type) {
        LESS_THAN -> {
            return i < secondConditional
        }
        LESS_THAN_OR_EQUAL -> {
            return i <= secondConditional
        }
        GREATER_THAN -> {
            return i > secondConditional
        }
        GREATER_THAN_OR_EQUAL -> {
            return i >= secondConditional
        }
        EQUAL -> {
            return i == secondConditional
        }
        NOT_EQUAL -> {
            return i != secondConditional
        }
    }
    return false
}