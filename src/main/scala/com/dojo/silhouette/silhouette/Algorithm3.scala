package com.dojo.silhouette.silhouette

object Algorithm3 extends AlgorithmSilhouette {

  def algorithm3(edifs: List[Building]): List[ElemSilhouette] =
    algorithm3(edifs, 0)

  def algorithm3(edifs: List[Building], depth: Int): List[ElemSilhouette] =
    depth match {
      case 20 => Algorithm2.algorithm2(edifs)
      case _ => edifs match {
        case Nil => Nil
        case x :: Nil => buildingSilhouette(x)
        case _ =>
          val (list1, list2) = edifs.splitAt(edifs.length / 2)
          union(algorithm3(list1, depth + 1), algorithm3(list2, depth + 1))
      }
    }

}
 