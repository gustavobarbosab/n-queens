package hillClimbing

import kotlin.math.abs

class HillClimbingBoard(var numberOfQueens: Int) {

    fun getBoard(): ArrayList<Int> {
        val queens = arrayListOf<Int>()
        for (i in 0 until numberOfQueens) {
            queens.add(i)
        }
        queens.shuffle()
        return queens
    }

    fun getNumberOfTreats(queens: ArrayList<Int>): Int {
        var treats = 0

        for (queen in 0 until queens.size) {
            for (nextQueen in (queen + 1) until queens.size) {
                if (queens[queen] == queens[nextQueen] || abs(queen - nextQueen) == abs(queens[queen] - queens[nextQueen]))
                    treats += 1
            }
        }

        return treats
    }
}