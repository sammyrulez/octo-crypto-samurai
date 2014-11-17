package com.sammyrulez.ocs.models
import org.scalatest._
import org.scalatest.junit.JUnitRunner
import org.junit.runner.RunWith

@RunWith(classOf[JUnitRunner])
class ModelTest  extends FlatSpec with Matchers {

  "An operation with positive amout of coins " should " be a deposit" in {
    val  o = Operation.apply(12.1)
    o.isInstanceOf[Deposit] should be (true);
    
  }
  
  "An operation with negative amout of coins " should " be a widthraw" in {
    val  o = Operation.apply(-22.1)
    o.isInstanceOf[Widthraw] should be (true);
    
  }

}