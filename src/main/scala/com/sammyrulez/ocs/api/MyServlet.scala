package com.sammyrulez.ocs.api
import org.scalatra._
import scalate.ScalateSupport

class MyServlet extends ScalatraServlet with ScalateSupport {

  get("/") {
    <html>
      <body>
        <h1>Hello, world!</h1>
        Say <a href="hello-scalate">hello to Scalate</a>.
      </body>
    </html>
  }
}
