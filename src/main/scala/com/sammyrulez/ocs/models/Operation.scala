package com.sammyrulez.ocs.models

import java.util.Date

trait Operation {
  
    def multipier:Integer 
    
    def value:Double
    
    val timestamp:Date
    
    val uid:String

}

class Deposit(coins:Double,val uid:String,val timestamp:Date = new Date()) extends Operation {
  
   def multipier:Integer = 1
      
   def value:Double  = coins;
  
}

class Widthraw(coins:Double,val uid:String,val timestamp:Date = new Date()) extends Operation {
  
   def multipier:Integer = -1
      
   def value:Double  = coins;
  
}


object Operation {
  
  def apply(coins:Double,uid:String,timestamp:Date = new Date()) = coins match{
    case d : Double if (coins > 0) => new Deposit(coins,uid,timestamp)
    case w : Double if (coins < 0)=> new Widthraw(coins,uid,timestamp)
    case _ => None
  }
  
}