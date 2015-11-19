package com.dojo.silhouette.silhouette


class MergeSort[T <% Ordered[T]] {
  def mergeSort(list1: List[T], list2: List[T], listR: List[T]): List[T] =
    list1 match {
      case List() => list2 ::: listR
      case x :: xs => list2 match {
        case List() => list1 ::: listR
        case y :: ys => if (x < y) mergeSort(xs, list2, x :: listR)
        else mergeSort(list1, ys, y :: listR)
      }
    }
}
