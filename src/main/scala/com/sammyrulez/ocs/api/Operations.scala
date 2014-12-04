package com.sammyrulez.ocs.api
import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._

class Operations extends ScalatraServlet with JacksonJsonSupport with AuthenticationSupport 
{

  protected implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal

  before() {
    contentType = formats("json")
    basicAuth
  }

  post("/deposit") {
       
      Map("result" ->"success") 
  }

  post("/withraw"){
    Map("result" -> "success") 
  }
}