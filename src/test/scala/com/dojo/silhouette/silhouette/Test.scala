package com.dojo.silhouette.silhouette

import org.scalatest.{FunSuite, _}

import scala.annotation.tailrec
import scala.io.Source


class Test extends FunSuite with Matchers {

  @tailrec
  final def parse(iterator: Iterator[String], count: Int, list: List[Building]): List[Building] = {
    assert((count != 0 && iterator.hasNext) || (count == 0 && iterator.isEmpty))
    if (count == 0) {
      return list
    }
    val words = iterator.next.split(" ")
    val a = words.drop(1)
    val b = a.drop(1)
    parse(iterator, count - 1, Building(words.head.trim.toInt, a.head.trim.toInt, b.head.trim.toInt) :: list)

  }

  def parse(iterator: Iterator[String]): List[Building] = {
    val count = iterator.next.trim.toInt

    parse(iterator, count, List())
  }

  test("verify algorithms") {
    val is = getClass.getResourceAsStream("/input.txt")
    val edif = parse(Source.fromInputStream(is, "UTF8").getLines)
    println("algoritmo1")
    val result1: List[ElemSilhouette] = Algorithm1.algorithm1(edif)
    result1.foreach(f => println(f))

    println("algoritmo2")
    val result2: List[ElemSilhouette] = Algorithm2.algorithm2(edif)
    result2.foreach(f => println(f))

    result1 shouldBe result2

    println("algoritmo3")
    val result3 = Algorithm3.algorithm3(edif)
    result3.foreach(f => println(f))

    result2 shouldBe result3
  }
}
