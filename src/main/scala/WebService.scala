package com.sammyrulez.ocs

import scala.concurrent.duration._
import akka.io.Tcp
import akka.actor._
import spray.http._
import MediaTypes._
import HttpMethods._


class WebService extends Actor with ActorLogging {
  def receive = {
    case HttpRequest(GET, Uri.Path("/api/"), _, _, _) =>
      sender ! index
    case HttpRequest(GET, Uri.Path("/api/ping"), _, _, _) =>
      sender ! HttpResponse(entity = "PONG!")
    case Timedout(request: HttpRequest) =>
      sender ! HttpResponse(500, "The " + request.method + " request to '" + request.uri + "' has timed out...")
  }
  ////////////// helpers //////////////
  lazy val index = HttpResponse(
    entity = HttpEntity(`text/html`,
      <html>
        <body>
          <h1>Say hello to <i>spray-servlet</i>!</h1>
          <p>Defined resources:</p>
          <ul>
            <li><a href="/api/ping">/ping</a></li>
          </ul>
        </body>
      </html>.toString
    )
  )

}
