package com.sammyrulez.ocs.api
import org.scalatra.test.scalatest._
import org.scalatest.FunSuiteLike

class HelloWorldServletTests extends ScalatraSuite with FunSuiteLike {
  // `HelloWorldServlet` is your app which extends ScalatraServlet
  addServlet(classOf[MyServlet], "/*")

  test("simple get") {
    get("/") {
      status should equal (200)
      body should include ("Hello")
    }
  }
}

