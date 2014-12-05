package com.sammyrulez.ocs.api

import org.scalatra.test.specs2._
import org.specs2.mock.Mockito
import org.mockito.Matchers._  
import org.specs2.mutable._

import javax.servlet.http._
import javax.servlet._
import org.scalatra.auth.Scentry
import net.iharder.Base64
import org.scalatra.ScalatraFilter

class OperationsServletTests extends MutableScalatraSpec with Mockito {    
        addServlet(classOf[Operations], "/*")    

        /*val basicCredentials = "Basic " + Base64.encodeBytes("scalatra:scalatra")   
        val authHeader = Map("Authorization" -> basicCredentials) */  
            var invalidateCalled = false
            val context = new ScalatraFilter {
                          private[this] val sessionMap = scala.collection.mutable.HashMap[String, Any](Scentry.scentryAuthKey -> "6789")
                          val mockSession = smartMock[HttpSession]
                          override def session(implicit request: HttpServletRequest) = mockSession
                          mockSession.getAttribute(anyString) answers { k => sessionMap.getOrElse(k.asInstanceOf[String], null).asInstanceOf[AnyRef] }
                          mockSession.setAttribute(anyString, anyObject) answers { (kv, wtfIsThis) =>
                            val Array(k: String, v: Any) = kv
                            sessionMap(k) = v
                          }
                          mockSession.invalidate() answers { k =>
                            invalidateCalled = true
                            sessionMap.clear()
                          }
            }

        implicit val req = mock[HttpServletRequest]

        implicit val res = mock[HttpServletResponse].smart 
 
        val mockedScentry = mock[Scentry[User]]
        mockedScentry.isAuthenticated returns true
        mockedScentry.authenticate returns new User("scalatra")

       "POST / on deposit" should {
            "return status 200" in {
             post("/deposit") {
                status must_== 200
              }
            }
          }
 }

