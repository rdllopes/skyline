package com.dojo.silhouette.silhouette

object JustASimpleCheck {

  def main(args: Array[String]): Unit = {
    val nums = (3 until 100).toList
    val somenums = nums filter (x => x % 3 == 0 || x % 5 == 0)
    val somenums2 = nums filter (x => x % 2 == 0 || x % 7 == 0)
    //(somenums reverse_::: somenums2).foreach(x => println(x))
    val v = new MergeSort[Int]
    v.mergeSort(somenums, somenums2, List()).foreach(x => println(x))
  }
}