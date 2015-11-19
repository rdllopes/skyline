package com.dojo.silhouette.silhouette

object Algorithm1 extends AlgorithmSilhouette {

  def algorithm1(edifs: List[Building]): List[ElemSilhouette] = {
    var s: List[ElemSilhouette] = Nil
    for (e <- edifs) {
      s = union(s, buildingSilhouette(e))
    }
    return s

  }
}
