package com.dojo.silhouette.silhouette

class Matrix[T: Manifest](_lines: Int, _columns: Int) {
  val lines  = _lines
  val columns = _columns
  val elements = new Array[T](lines * columns)

  def apply(line: Int, column: Int): T = elements(columns * line + column)

  def update(line: Int, column: Int, value: T): Unit = elements(columns * line + column) = value
}

class ImagePGM {
  val NLins = 600
  val NCols = 800
  val BorderInf = NLins - 1
  val MarginInf = 20
  val Base = BorderInf - MarginInf
  val white = 15
  val grey = 10
  val black = 0

  def generateImage(s: List[ElemSilhouette], nomeArq: String): Unit = {
    var left = 0;
    var right = 0;
    var height = 0;

    val a = new Matrix[Int](NLins, NCols)

    for (silhueta <- s) {
      right = silhueta.x
      if (left != 0) fillRectangle(a, left, right, MarginInf, height, grey)
      left = silhueta.x
      height = silhueta.h
    }

    fillRectangle(a, 0, NCols, Base, BorderInf, black) //painting the base as black

    val file = new java.io.FileWriter(nomeArq)
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
      for (j <- col1 to col2)
        a(i, j) = k

  }
}
