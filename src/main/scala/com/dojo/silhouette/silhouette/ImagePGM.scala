package com.dojo.silhouette.silhouette


/**
 This is a Portable gray map facility.
 */
class ImagePGM {
  val NLins = 30
  val NCols = 30
  val BorderInf = NLins - 1
  val MarginInf = 3
  val Base = BorderInf - MarginInf
  val white = 15
  val grey = 10
  val black = 0

  def generateImage(s: List[ElemSilhouette], filename: String): Unit = {
    var left = 0;
    var right = 0;
    var height = 0;

    val a = new Matrix[Int](NLins, NCols)

    for (silhouette <- s) {
      right = silhouette.x
      if (left != 0) {
        fillRectangle(a, height, Base, left, right, grey)
        fillRectangle(a, 0, height, left, right, white)
      }
      left = silhouette.x
      height = Base - silhouette.h
    }

    fillRectangle(a, Base, BorderInf, 0, NCols-1, black) //painting the base as black

    val file = new java.io.FileWriter(filename)
    file.write("P2\n")
    file.write(NCols + " " + NLins + "\n")
    file.write(white + "\n")

    for (i <- 0 to a.lines - 1) {
      for (j <- 0 to a.columns - 1)
        file.write(a(i, j) + " ")

      file.write("\n")
    }

    file.close
  }

  def fillRectangle(a: Matrix[Int], lin1: Int, lin2: Int, col1: Int, col2: Int, k: Int): Unit = {
    for (i <- lin1 to lin2)
      for (j <- col1 to col2){
        a(i, j) = k
      }

  }
}
