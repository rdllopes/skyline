package com.dojo.silhouette.silhouette

import scala.annotation.tailrec

class AlgorithmSilhouette {

  def silhouetteWithFoldLeft(edifs: List[Building]): List[ElemSilhouette] = {
    edifs.foldLeft(List[ElemSilhouette]())((x: List[ElemSilhouette], y: Building) => union(x, buildingSilhouette(y)))
  }

  def buildingSilhouette(edif: Building): List[ElemSilhouette] = {
    ElemSilhouette(edif.left, 0) :: List(ElemSilhouette(edif.right, edif.height))
  }

  def union(s1: List[ElemSilhouette],
            s2: List[ElemSilhouette]): List[ElemSilhouette] = s2 match {
    case Nil => s1
    case _ => union(s1, s2, List(), null)
  }


  def simplify(alt: Int,
                 s3: List[ElemSilhouette],
                 last: ElemSilhouette
                  ): List[ElemSilhouette] =
    if (last == null) s3
    else
      s3 match {
        case Nil => last :: Nil
        case _ =>
          if (last != null && alt != last.h) {
            last :: s3
          } else s3
      }


  @tailrec
  final def union(s1: List[ElemSilhouette],
                  s2: List[ElemSilhouette],
                  s3: List[ElemSilhouette],
                  last: ElemSilhouette
             ): List[ElemSilhouette] = {
    s1 match {
      case Nil => simplify(s2.head.h, s3, last) reverse_::: s2
      case x :: xs =>
        s2 match {
          case Nil => simplify(s1.head.h, s3, last) reverse_::: s1
          case y :: ys =>
            val alt = if (x.h > y.h) x.h else y.h
            val result = simplify(alt, s3, last)
            if (x.x < y.x) {
              union(xs, s2, result, if (last != null && last.x == x.x) null else ElemSilhouette(x.x, alt))
            } else {
              union(s1, ys, result, if (last != null && last.x == y.x) null else ElemSilhouette(y.x, alt))
            }
        }
    }

  }

}