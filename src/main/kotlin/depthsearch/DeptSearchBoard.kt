package depthsearch

class DeptSearchBoard(val baseNumber: Int) {
    val positions: ArrayList<ArrayList<Int>> = BoardCreator.create(baseNumber, baseNumber)
}