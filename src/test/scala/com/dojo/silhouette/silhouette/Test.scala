package com.dojo.silhouette.silhouette

import org.scalatest.{FunSuite, _}

import scala.annotation.tailrec
import scala.io.Source


class Test extends FunSuite with Matchers {

  test("verify algorithms") {
    val is = getClass.getResourceAsStream("/input.txt")
    val edif = Skyline.parse(Source.fromInputStream(is, "UTF8").getLines)
    println("algoritmo1")
    val result1: List[ElemSilhouette] = IterativeAlgorithm.process(edif)
    result1.foreach(f => println(f))

    println("algoritmo2")
    val result2: List[ElemSilhouette] = TailRecursiveAlgorithm.process(edif)
    result2.foreach(f => println(f))

    result1 shouldBe result2

    println("algoritmo3")
    val result3 = RecursiveAlgorithm.process(edif)
    result3.foreach(f => println(f))

    result2 shouldBe result3
  }
}
