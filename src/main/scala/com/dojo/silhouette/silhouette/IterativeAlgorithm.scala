package com.dojo.silhouette.silhouette

object IterativeAlgorithm extends AlgorithmSilhouette {

  override def process(edifs: List[Building]): List[ElemSilhouette] = {
    var s: List[ElemSilhouette] = Nil
    for (e <- edifs) {
      s = union(s, buildingSilhouette(e))
    }
    return s

  }
}
