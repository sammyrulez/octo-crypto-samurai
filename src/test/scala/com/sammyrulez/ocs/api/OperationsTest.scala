package com.sammyrulez.ocs.api
import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike
import net.iharder.Base64

class OperationsServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[Operations], "/*")

  val basicCredentials = Base64.encodeBytes("scalatra:scalatra".getBytes())
  val authHeader = Map("Authorization" -> basicCredentials)



  test("Post to deposit") {
    post("/deposit", authHeader) {
      status should equal (200)
      body should include ("success")
    }
  }
}

