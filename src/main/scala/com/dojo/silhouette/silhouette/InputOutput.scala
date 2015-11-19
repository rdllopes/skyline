package com.dojo.silhouette.silhouette

import com.dojo.silhouette.silhouette

import scala.io._

class InputOutput {
  def readInput(arq: String): Int = {
    val edifs: List[com.dojo.silhouette.silhouette.Building] = List()
    var numBuildings = 0
    for (line <- Source.fromFile(arq).getLines.toList) {
      if (line.length == 1) {
        numBuildings = line.head
      }
      else {
        val edif = silhouette.Building(line.head, line.tail.toInt, line.tail.tail.toInt)
        edif :: edifs
      }
    }
    numBuildings
  }

  def writeOutput(silhouette: List[ElemSilhouette], fileName: String): Unit = {
    val file = new java.io.FileWriter(fileName)
    file.write(silhouette.length + "\n")
    for (s <- silhouette)
      file.write(s.x + " " + s.h + "\n")

    file.close
  }

}
