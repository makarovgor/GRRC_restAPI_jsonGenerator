package json

import io.circe.generic.semiauto.{ deriveDecoder, deriveEncoder }
import io.circe.syntax.EncoderOps
import io.circe.{ Decoder, Encoder }

import java.time.Instant

case class Json(id: Int, text: String, time: Instant)

object Json {

  implicit val decodeJson: Decoder[Json] = deriveDecoder[Json]

  implicit val encodeJson: Encoder[Json] = deriveEncoder[Json]

  val EmptyId: Int    = 0
  val EmptyIdLen: Int = EmptyId.toString.getBytes.length
  val Empty: Json     = Json(EmptyId, "", Instant.now())
  val EmptyLen: Int   = Empty.asJson.noSpaces.getBytes.length - EmptyIdLen

  val maxLenStr       = 100
  val minJsonLen: Int = Empty.asJson.noSpaces.getBytes().length
  val maxJsonLen: Int = minJsonLen + maxLenStr

}
