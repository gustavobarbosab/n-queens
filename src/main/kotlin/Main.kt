import depthsearch.DepthSearchSolver
import java.util.Scanner

fun main(args: Array<String>) {
    val input = Scanner(System.`in`)
    println("Por favor insira o valor para N:")
    val n = input.nextInt()

    println("SOLUÇÕES USANDO BUSCA EM PROFUNDIDADE")
    val solver = DepthSearchSolver(n)
    solver.solve()
}