package day6

val input = "11\t11\t13\t7\t0\t15\t5\t5\t4\t4\t1\t1\t7\t1\t15\t11"
//val input = "0\t2\t7\t0"

fun main(args: Array<String>) {
    println("Part one ${partOne(input.split('\t') as MutableList<String>)}")
    println("Part two ${partTwo()}")
}


fun partOne(memory: MutableList<String>): Int {
    var duplicate = false
    var count = 0
    var history: MutableList<String> = mutableListOf<String>()
    while (!duplicate) {
        var highest = 0
        var indexOfHighest = 0
        var tempString = ""
        memory.forEachIndexed { index, memoryCount ->
            if (memoryCount.toInt() > highest) {
                highest = memoryCount.toInt()
                indexOfHighest = index
            }
            tempString += memoryCount
        }
        history.add(tempString)
        var currentIndex = indexOfHighest + 1
        memory[indexOfHighest] = 0.toString()
        while (highest > 0) {
            if (currentIndex > memory.size - 1) {
                currentIndex %= memory.size
            }
            memory[currentIndex] = (memory[currentIndex].toInt() + 1).toString()
            highest--
            currentIndex++
        }
        var tempString2 = ""
        memory.forEach { value ->
            tempString2 += value
        }
        duplicate = history.contains(tempString2)
        count++
    }
    return count
}

fun partTwo(): Int {
    var sum = 0
    return sum
}