package day7

import java.io.File
import java.io.InputStream

fun main(args: Array<String>) {
    val inputStream: InputStream = File("/Users/zangardiw/Sandbox/KotlinAdventOfCode2017/src/day7/Day7TestInput.txt").inputStream()
    val lineList1 = mutableListOf<String>()
    val lineList2 = mutableListOf<String>()
    inputStream.bufferedReader().useLines { lines ->
        lines.forEach {
            lineList1.add(it)
            lineList2.add(it)
        }
    }
    println("Part one ${partOne(lineList1)}")
    println("Part two ${partTwo(lineList2)}")
}

fun partOne(input: MutableList<String>): Int {
    val towers: MutableList<Tower> = mutableListOf<Tower>()
    input.forEachIndexed line@ { index, line ->
        var tower: Tower = Tower()
        poorMansRegex(line).split(" ").forEachIndexed { index2, string ->
            when (index2) {
                0 -> {
                    tower.name = string
                }
                1 -> {
                    tower.weight = string
                }
                2 -> {
                    val children: MutableList<Tower> = mutableListOf<Tower>()
                    string.split(",").forEach {
                        val child = Tower()
                        child.name = it
                        children.add(child)
                    }
                    tower.children = children
                }
            }
        }
        towers.add(tower)
    }
    buildStructure(towers)
    return 0
}

fun buildStructure(towers: MutableList<Tower>) {
    towers.forEachIndexed { index, tower ->
        if(tower.hasChildren()) {
            tower.children.forEachIndexed { index, tower ->
                //tower.children[index] = to
            }
        }
    }
}

fun partTwo(input: MutableList<String>): Int {
    var sum = 0
    return sum
}

fun poorMansRegex(input: String): String {
    return input.replace(", ", ",").replace(" -> ", " ").replace("(", "").replace(")", "")
}

class Tower {
    var name = ""
    var weight = ""
    var children: MutableList<Tower> = mutableListOf<Tower>()
    fun hasChildren(): Boolean {
        return children.isNotEmpty()
    }
}