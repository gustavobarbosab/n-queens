import depthsearch.DepthSearchSolver
import hillClimbing.Board
import hillClimbing.HillClimbing
import simulatedAnnealing.SimulatedAnnealing
import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println("Por favor insira o valor para N:")
    val n = input.nextInt()

    println("SOLUÇÕES USANDO BUSCA EM PROFUNDIDADE")
    val solver = DepthSearchSolver(n)
    solver.solve()

    println()
    println("SOLUÇÃO USANDO HILL CLIMBING")
    val initialBoard = Board(n)
    HillClimbing(initialBoard).run()

    println()
    println("SOLUÇÃO USANDO SIMULATEDANNEALING")
    SimulatedAnnealing(initialBoard).run()

}