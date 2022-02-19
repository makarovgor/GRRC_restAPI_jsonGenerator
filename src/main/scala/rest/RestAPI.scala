package rest

import com.twitter.finagle.http.Response
import com.twitter.finagle.http.path._
import com.twitter.finagle.{ Http, ListeningServer, Service, http }
import com.twitter.util.{ Await, Future }
import json.generator.JsonGenerator

object RestAPI {
  val service = new Service[http.Request, http.Response] {

    def apply(req: http.Request): Future[http.Response] =
      Future {
        val resp = Response(req.version, http.Status.Ok)

        (req.method, Path(req.path)) match {
          case http.Method.Get -> Root / "api" / "generate" =>
            req.params.getInt("size") match {
              case Some(size) =>
                if (size > 0) {
                  resp.setContentType("application/json")
                  resp.setContentString(new JsonGenerator(size).res + "\n")
                } else {
                  resp.status(http.Status.BadRequest)
                  resp.write("400 - BadRequest: size value should be more than 0" + "\n")
                }
              case None =>
                resp.status(http.Status.BadRequest)
                resp.write("400 - BadRequest: size value Not Found" + "\n")
            }
          case _ => resp.status(http.Status.NotFound)
        }
        resp
      }
  }

  val server: ListeningServer = Http.serve(":8080", service)

  Await.ready(server)

  sys.addShutdownHook {
    Await.ready(server.close())
  }
}
