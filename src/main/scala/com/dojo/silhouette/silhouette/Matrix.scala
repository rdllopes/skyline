package com.dojo.silhouette.silhouette

class Matrix[T: Manifest](_lines: Int, _columns: Int) {
  val lines  = _lines
  val columns = _columns
  val elements = new Array[T](lines * columns)

  def apply(line: Int, column: Int): T = elements(columns * line + column)

  def update(line: Int, column: Int, value: T): Unit = elements(columns * line + column) = value
}
