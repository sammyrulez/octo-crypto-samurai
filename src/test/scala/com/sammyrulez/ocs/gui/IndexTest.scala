package com.sammyrulez.ocs.gui
import org.scalatest._
import org.scalatest.selenium.Firefox

class IndexSpec extends FlatSpec with ShouldMatchers with Firefox {

  val host = "http://localhost:8080/"

  "The app home page" should "have the correct title" in {
    go to (host + "index.html")
    pageTitle should be ("Starter Template for Bootstrap")
    close()
  }
}
