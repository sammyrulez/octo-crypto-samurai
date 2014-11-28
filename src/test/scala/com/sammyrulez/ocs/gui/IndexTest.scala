package com.sammyrulez.ocs.gui
import org.scalatest._
import org.scalatest.selenium.Firefox
import org.scalatest.selenium.HtmlUnit

class IndexSpec extends FlatSpec with ShouldMatchers with Firefox {

  val host = "http://localhost:9090/"

   "The app home page" should "have the correct title" in {
    go to (host + "index.html")
    pageTitle should be ("BitRyu")
    close()
  }

  "The app home page" should "have the correct exchange value" in {
    go to (host + "index.html")
    id("quoteValue").element.text should be ("123")
    close()
  }
}
