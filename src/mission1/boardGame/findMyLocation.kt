package mission1.boardGame

import java.util.Scanner

val fromToLadder: MutableMap<Int, Int> = mutableMapOf(
    4 to 14, 8 to 30, 21 to 42, 28 to 76,
    50 to 67, 71 to 92, 80 to 99
)
val fromToSnake: MutableMap<Int, Int> = mutableMapOf(
    97 to 78, 95 to 56, 88 to 24, 62 to 18,
    48 to 26, 36 to 6, 32 to 10
)

fun main() {

    var now = 1

    while(true) {
        print("roll? or not?")
        var command = Scanner (System.`in`)
        if(command.next() != "roll") break

        print("now: $now")
        var dice = rollTheDice()
        println(" -> dice:  $dice")
        now = move(now, dice)
        println("now: $now")
        if(now == 100) {
            println("won!")
            break
        }
    }

}

fun rollTheDice(): Int = (1..6).random()

fun move(curLoc: Int, dice: Int): Int {
    var loc = curLoc + dice

    // 범위 벗어남
    if(curLoc+dice>100) return 100

    if(fromToLadder.containsKey(curLoc)) return moveToLadder(curLoc)!!
    else if(fromToSnake.containsKey(curLoc)) return moveToSnake(curLoc)!!

    return loc
}

fun moveToLadder(curLoc: Int): Int? {
    val loc = fromToLadder[curLoc]
    println("$curLoc --사다리--> $loc")
    return loc
}
fun moveToSnake(curLoc: Int): Int? {
    val loc = fromToSnake[curLoc]
    println("$curLoc --뱀--> $loc")
    return loc
}