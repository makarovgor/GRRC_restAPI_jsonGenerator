package testJson

import io.circe.Json
import json.generator.JsonGenerator
import org.scalatest.funsuite.AnyFunSuite

object jsonTest

class CalculatorSuite extends AnyFunSuite {

  val error: Double = 1.04

  def gen(bytes: Int): Json = new JsonGenerator(bytes).res

  test("length of Generator N bytes always should be more than N") {
    List.range(55, 100000, 10000)
      .map(n =>
        assert(gen(n).noSpaces.getBytes.length >= n ))
  }

  test("length of Generator N bytes always should be less than N") {
    List.range(55, 100000, 10000)
      .map(n =>
        assert(gen(n).noSpaces.getBytes.length <= n * error))
  }

  test(s"length of Generator < ${json.Json.minJsonLen}") {
    List.range(2, 55, 3)
      .map(n => assert(gen(n).noSpaces.getBytes.length <= n))
  }
}
