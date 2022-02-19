package rpc

import io.grpc.ServerBuilder
import service.service_json._

import scala.concurrent.ExecutionContext

object GRPC extends App {

  val service = JsonServiceGrpc.bindService(new JsonServiceImpl, ExecutionContext.global)

  val builder = ServerBuilder.forPort(9000)
  builder.addService(service)
  var server = builder.build.start

  server.awaitTermination()

  sys.addShutdownHook {
    server.shutdown()
  }
}
