package json.generator

import io.circe.syntax._
import json.Json

import java.time.Instant

class JsonGenerator(val bytes: Int) {

  private def rndStr(n: Int): String =
    1.to(n).view.map(_ => util.Random.nextPrintableChar()).mkString

  private def listGenerator(id: Int, n: Int = Json.maxLenStr): LazyList[Json] =
    generateJson(id, n) #:: listGenerator(id + 1, n)

  private def generateJson(id: Int, n: Int = Json.maxLenStr): Json =
    Json(id, rndStr(scala.util.Random.nextInt(n)), Instant.now)

  def resList: LazyList[Json] = {
    var jsonLen = 0

    val temp = listGenerator(1).takeWhile { el =>
      jsonLen += (el.text.getBytes.length + el.id.toString.getBytes.length + Json.EmptyLen)
      jsonLen < (bytes - Json.minJsonLen)
    }

    if (temp.isEmpty && bytes >= Json.minJsonLen) {
      listGenerator(1, bytes - Json.EmptyLen).take(1)
    } else if (temp.isEmpty && bytes < Json.minJsonLen) {
      temp
    } else {
      temp.lazyAppendedAll(LazyList(generateLast(temp)))
    }
  }

  def res: io.circe.Json =
    resList.asJson

  def generateLast(lst: LazyList[Json]): Json =
    Json(
      lst.last.id + 1,
      rndStr(bytes - lst.asJson.noSpaces.getBytes.length - Json.EmptyLen - (lst.last.id + 1).toString.getBytes.length),
      Instant.now()
    )
}
