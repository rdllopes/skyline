package com.dojo.silhouette.silhouette

import java.io._

import scala.io._


object Silhouette {

  // def algoritmo1(edifs: List[Edificio]): List[ElemSilhueta] = {}

  def main(args: Array[String]) = {
    val inputStream = new FileInputStream("input.txt")
    for (line <- Source.fromInputStream(inputStream, "UTF8").getLines) {
      println(line)
    }
  }
}

