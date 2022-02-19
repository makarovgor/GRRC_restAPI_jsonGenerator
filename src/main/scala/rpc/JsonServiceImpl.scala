package rpc

import io.circe.syntax.EncoderOps
import io.grpc.Status
import io.grpc.stub.StreamObserver
import json.Json
import json.generator.JsonGenerator
import service.service_json._

import scala.concurrent.ExecutionContext.Implicits.global
import scala.concurrent.Future

private class JsonServiceImpl extends JsonServiceGrpc.JsonService {

  override def unary(request: JsonReq1): Future[JsonResp1] = Future {
    request.bytes match {
      case size if size >= Json.minJsonLen =>
        JsonResp1(Some(new JsonGenerator(request.bytes).res.noSpaces))
      case _ =>
        throw new IllegalArgumentException(s"value bytes should not be less than ${Json.minJsonLen}")
    }
  }

  override def serverStreaming(request: JsonReq2, responseObserver: StreamObserver[JsonResp2]): Unit =
    if (request.size >= Json.minJsonLen * request.batchSize) {
      val temp = new JsonGenerator(request.size).resList.map(_.asJson.noSpaces).grouped(request.batchSize)
      temp.foreach(el => responseObserver.onNext(JsonResp2(el)))
      responseObserver.onCompleted()
    } else {
      val status =
        Status.INVALID_ARGUMENT.withDescription(s"size should not be less than ${Json.minJsonLen * request.batchSize}")
      responseObserver.onError(status.asException())
    }
}
