package depthsearch

object BoardCreator {

    fun create(rows: Int, columns: Int): ArrayList<ArrayList<Int>> {
        val matrix = arrayListOf<ArrayList<Int>>()
        for (row in 0 until rows) {
            val matRow = arrayListOf<Int>()
            for (column in 0 until columns) {
                matRow.add(0)
            }
            matrix.add(matRow)
        }
        return matrix
    }
}