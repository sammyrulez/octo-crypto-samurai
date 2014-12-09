package com.sammyrulez.ocs.api
import org.scalatra.ScalatraServlet
import org.scalatra.swagger.{ApiInfo, NativeSwaggerBase, Swagger}


class ResourcesApp(implicit val swagger: Swagger) extends ScalatraServlet with NativeSwaggerBase

object OperationsApiInfo extends ApiInfo(
    "The CryptoRyu Operations API",
    "Docs for the CryptoRyu Operations API",
    "http://scalatra.org",
    "apiteam@scalatra.org",
    "MIT",
    "http://opensource.org/licenses/MIT")

class OperationsSwagger extends Swagger(Swagger.SpecVersion, "1.0.0", OperationsApiInfo)
