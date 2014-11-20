package com.sammyrulez.ocs

import scala.concurrent.duration._
import akka.io.Tcp
import akka.actor._
import spray.http._
import spray.routing._
import MediaTypes._
import HttpMethods._
import spray.json._
import spray.routing.directives.LogEntry
import akka.event.Logging._


object ChangeJsonProtocol extends DefaultJsonProtocol {
  implicit val changeFormat = jsonFormat3(Change)
}
class WebService extends Actor with HttpService with ActorLogging {
  implicit def actorRefFactory = context
  def receive = runRoute(route)
  import ChangeJsonProtocol._
  import spray.httpx.SprayJsonSupport._
  lazy val route = {
                get {                    
                    path("exchange") {                        
                            complete{
                            new Change(1,"euro",0.11)
                            }                         
                    } ~
                    path("exchange" / Segment){(currency) =>
                            complete{
                            new Change(1,currency,0.11)
                            }
                         }                   
                }
      }
    
  
}

case class Change(value: Double, currency: String, trend: Double)
