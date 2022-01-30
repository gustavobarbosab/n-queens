package simulatedAnnealing

import hillClimbing.HillClimbingBoard
import kotlin.random.Random

class SimulatedAnnealingSolver(
    var initialBoard: HillClimbingBoard,
    var temperatureReductionFactor : Double = 0.99,
    var initialTemperature : Int = 2000,
    var numberOfIterations : Int = 10000000,
) {

    fun solve() {

        var temperature = initialTemperature.toDouble()
        var currentBoard = initialBoard.getBoard()
        var haveSolution = false

        for (i in 0 until numberOfIterations) {
            // reduce temperature
            temperature *= temperatureReductionFactor

            // select neighbor
            val neighbor = initialBoard.getBoard()

            val delta = initialBoard.getNumberOfTreats(neighbor) - initialBoard.getNumberOfTreats(currentBoard)
            val exp = (-delta) / temperature
            val random = Random.nextDouble(0.0,1.0)

            if (delta > 0 || random < exp) {
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