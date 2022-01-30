import depthsearch.DeptSearchBoard
import depthsearch.DepthSearchSolver
import hillClimbing.HillClimbingBoard
import hillClimbing.HillClimbingSolver
import simulatedAnnealing.SimulatedAnnealingSolver
import timemeasure.TimeMeasure
import java.util.Scanner
import java.util.concurrent.TimeUnit

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println("Por favor insira o valor para N:")
    val n = input.nextInt()

    val depthSearchTime = TimeMeasure.measure(TimeUnit.MILLISECONDS) {
        println("SOLUÇÕES USANDO BUSCA EM PROFUNDIDADE")
        val board = DeptSearchBoard(n)
        DepthSearchSolver(board).solve()
    }
    println("Tempo total Busca em profundidade: $depthSearchTime milis")

    val hillClimbSearchTime = TimeMeasure.measure(TimeUnit.MILLISECONDS) {
        println("\nSOLUÇÃO USANDO HILL CLIMBING")
        val initialBoard = HillClimbingBoard(n)
        HillClimbingSolver(initialBoard).solve()
    }
    println("Tempo total Hill Climbing: $hillClimbSearchTime milis")

    val simulatedAnnealingSearchTime = TimeMeasure.measure(TimeUnit.MILLISECONDS) {
        val initialBoard = HillClimbingBoard(n)
        println("\nSOLUÇÃO USANDO SIMULATED ANNEALING")
        SimulatedAnnealingSolver(initialBoard, 0.99, 1000).solve()
    }
    println("Tempo total Simulated Annealing: $simulatedAnnealingSearchTime milis")
}