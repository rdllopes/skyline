package com.dojo.silhouette.silhouette

import java.io.FileInputStream

import scala.annotation.tailrec
import scala.io._


object Skyline {

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

  def main(args: Array[String]) = {
    val is = new FileInputStream(args(0))
    val edif = parse(Source.fromInputStream(is, "UTF8").getLines)
    val result = args.length match {
      case 2 => TailRecursiveAlgorithm.process(edif)
      case 3 => args(2) match {
        case "recursive" => RecursiveAlgorithm.process(edif)
        case "iterative" => IterativeAlgorithm.process(edif)
        case "tail" | _ => TailRecursiveAlgorithm.process(edif)
      }
    }

    new ImagePGM().generateImage(result, args(1))

  }

}

