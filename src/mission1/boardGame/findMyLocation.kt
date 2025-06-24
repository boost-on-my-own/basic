package mission1.boardGame

import java.util.Scanner

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

    val fromToLoc: MutableMap<Int, Int> = mutableMapOf(
        4 to 14, 8 to 30, 21 to 42, 28 to 76,
        50 to 67, 71 to 92, 80 to 99
    )

    // fromToLoc[loc] : Map에서 loc의 키값을 가진 value를 거냄. (타입은 Int?)
    // ?. : null 이 아니면 let 실행.
    // it : 예약어는 x. Kotlin 람다에서 기본적으로 사용되는 매개변수 이름.
    fromToLoc[loc]?.let { loc = it }

    return loc
}