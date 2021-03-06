package com.dojo.silhouette.silhouette

import scala.annotation.tailrec

object TailRecursiveAlgorithm extends AlgorithmSilhouette {

  override def process(edifs: List[Building]): List[ElemSilhouette] = {
    algorithm_aux(edifs, List())
  }

  @tailrec
  def algorithm_aux(edifs: List[Building], silhouette: List[ElemSilhouette]): List[ElemSilhouette] = {
    edifs match {
      case List() => silhouette
      case head :: tail => algorithm_aux(tail, union(buildingSilhouette(head), silhouette))
    }
  }
}
