package hillClimbing

class HillClimbingSolver(
    var initialBoard: HillClimbingBoard,
    var numberOfIterations: Int = 10000000,
) {
    fun solve() {
        var currentBoard = initialBoard.getBoard()
        var haveSolution = false

        for (i in 0 until numberOfIterations) {
            // select neighbor
            val neighbor = initialBoard.getBoard()

            if (initialBoard.getNumberOfTreats(neighbor) < initialBoard.getNumberOfTreats(currentBoard)) {
                currentBoard = neighbor
            }

            if (initialBoard.getNumberOfTreats(currentBoard) == 0) {
                haveSolution = true
                print("Solução $i: $currentBoard")
                println()
                break
            }
        }
        if (!haveSolution) {
            print("Não foi possível encontrar solução")
        }
    }
}