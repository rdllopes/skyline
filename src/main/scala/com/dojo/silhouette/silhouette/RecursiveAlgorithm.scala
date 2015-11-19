package com.dojo.silhouette.silhouette

object RecursiveAlgorithm extends AlgorithmSilhouette {


  override def process(edifs: List[Building]): List[ElemSilhouette] =
    process(edifs, 0)

  def process(edifs: List[Building], depth: Int): List[ElemSilhouette] =
    depth match {
      case 20 => TailRecursiveAlgorithm.process(edifs)
      case _ => edifs match {
        case Nil => Nil
        case x :: Nil => buildingSilhouette(x)
        case _ =>
          val (list1, list2) = edifs.splitAt(edifs.length / 2)
          union(process(list1, depth + 1), process(list2, depth + 1))
      }
    }

}
 