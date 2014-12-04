package com.sammyrulez.ocs.api
import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class OperationsServletTests extends ScalatraSuite with FunSuiteLike {

  addServlet(classOf[Operations], "/*")

  test("Post to deposit") {
    post("/deposit") {
      status should equal (200)
      body should include ("success")
    }
  }
}

