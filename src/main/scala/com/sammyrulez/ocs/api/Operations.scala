package com.sammyrulez.ocs.api
import org.scalatra._
import org.json4s.{DefaultFormats, Formats}
import org.scalatra.json._
import org.scalatra.swagger._

class Operations(implicit val swagger: Swagger) extends ScalatraServlet with NativeJsonSupport with AuthenticationSupport with SwaggerSupport
{

  protected val applicationDescription = "CryptoRyu Operation API"

  protected implicit val jsonFormats: Formats = DefaultFormats.withBigDecimal

  before() {
    contentType = formats("json")
    basicAuth
  }

   val depositApi =
    (apiOperation[Map[String,String]]("deposit")
      summary "deposit cyrptoRyus"
      notes "Add cryptoryus to your deposit")
   
  post("/deposit", operation(depositApi)) {
       
      Map("result" ->"success") 
  }

  val withrawApi =
    (apiOperation[Map[String,String]]("withraw")
      summary "withraw cyrptoRyus"
      notes "Remove cryptoryus from your deposit")

  post("/withraw", operation(withrawApi)){
    Map("result" -> "success") 
  }
}
