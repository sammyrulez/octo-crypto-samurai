package com.sammyrulez.ocs.models
import org.scalatest._
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith
import java.util.Date

@RunWith(classOf[JUnitRunner])
class ModelTest  extends FlatSpec with Matchers {

  "An operation with positive amout of coins " should " be a deposit" in {
    val  o = Operation.apply(12.1,"x")
    o.isInstanceOf[Deposit] should be (true);
    
  }
  
  "An operation with negative amout of coins " should " be a widthraw" in {
    val  o = Operation.apply(-22.1,"x")
    o.isInstanceOf[Widthraw] should be (true);
    
  }
  
   "An operation " should " have a default timestamp" in {
    val  o = new Deposit(123,"x")
    o.timestamp should be <= new Date() 
    
  }
   
    "An operation " should " have a immutable timestamp" in {
      
    val t =new Date()  
    val  o = new Deposit(123,"x",t)
    o.timestamp should be theSameInstanceAs t 
    
  }

}