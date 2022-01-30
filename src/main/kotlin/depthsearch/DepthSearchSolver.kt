package depthsearch

import kotlin.math.absoluteValue

class DepthSearchSolver(private val board: DeptSearchBoard) {

    var queensFound: Int = 0
    var solutions: Int = 0

    fun solve() {
        search(0)
        println("Soluções: ${solutions}")
    }

    private fun search(recursiveColumn: Int) {
        if (queensFound >= board.baseNumber) {
            printBoard()
            solutions++
            return
        }

        for (currentRow in 0 until board.baseNumber) {
            if (board.positions[currentRow][recursiveColumn] < 0) {
                continue
            }

            // Put the queen and mark cells in cross and diagonal
            board.positions[currentRow][recursiveColumn] = 1
            markCross(currentRow, recursiveColumn, this::sub)
            markDiagonal(currentRow, recursiveColumn, this::sub)
            queensFound++

            search(recursiveColumn + 1)

            board.positions[currentRow][recursiveColumn] = 0
            markCross(currentRow, recursiveColumn, this::add)
            markDiagonal(currentRow, recursiveColumn, this::add)
            queensFound--
        }
    }

    private fun markCross(currentRow: Int, recursiveColumn: Int, operation: (Int, Int) -> Unit) {
        for (currentColumn in 0 until board.baseNumber) {
            if (currentColumn != recursiveColumn)
                operation(currentRow, currentColumn)

            if (currentColumn != currentRow)
                operation(currentColumn, recursiveColumn)
        }
    }

    private fun markDiagonal(currentRow: Int, recursiveColumn: Int, operation: (Int, Int) -> Unit) {
        for (currentColumn in 1 until board.baseNumber) {
            // Top Left
            var line = currentRow - currentColumn
            var column = recursiveColumn - currentColumn
            if (line >= 0 && column >= 0)
                operation(line, column)

            // Bottom Right
            line = currentRow + currentColumn
            column = recursiveColumn + currentColumn
            if (line < board.baseNumber && column < board.baseNumber)
                operation(line, column)

            // Top Right
            line = currentRow - currentColumn
            column = recursiveColumn + currentColumn
            if (line >= 0 && column < board.baseNumber)
                operation(line, column)

            // Bottom Left
            line = currentRow + currentColumn
            column = recursiveColumn - currentColumn
            if (line < board.baseNumber && column >= 0)
                operation(line, column)
        }
    }

    fun sub(line: Int, column: Int) {
        board.positions[line][column]--
    }

    fun add(line: Int, column: Int) {
        board.positions[line][column]++
    }

    private fun printBoard() {
        board.positions.forEach { rows ->
            rows.forEach {
                val value = if (it == 1) "Q" else it.absoluteValue.toString()
                print("$value ")
            }
            println()
        }
        println()
    }
}