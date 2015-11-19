package com.dojo.silhouette.silhouette

import org.scalatest.{FunSuite, Matchers}

import scala.annotation.tailrec
import scala.io.Source


class Test3 extends FunSuite with Matchers {

  @tailrec
  final def createSilhouette(words: Array[String], list: List[ElemSilhouette]): List[ElemSilhouette] = words match {
    case Array() => list
    case _ =>
      val a = words.drop(1)
      val b = a.drop(1)
      createSilhouette(b, list ::: List(ElemSilhouette(a.head.trim.toInt, words.head.trim.toInt)))

  }

  @tailrec
  final def parse(iterator: Iterator[String], list: List[List[ElemSilhouette]]): List[List[ElemSilhouette]] = {
    if (!iterator.hasNext) {
      return list
    }
    val words = iterator.next.split(",")
    val result = list ::: List(createSilhouette(words, List()))
    parse(iterator, result)
  }

  test("verify algorithm1") {
    val is = getClass.getResourceAsStream("/input2.txt")
    val edif = parse(Source.fromInputStream(is, "UTF8").getLines, List())
    val alg = new AlgorithmSilhouette()
    val res = alg.union(edif.head, edif.last)
    res.foreach(f => println(f))
  }
}
