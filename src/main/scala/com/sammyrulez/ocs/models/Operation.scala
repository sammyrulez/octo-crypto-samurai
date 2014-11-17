package com.sammyrulez.ocs.models

trait Operation {
  
    def multipier:Integer 
    
    def value:Double

}

class Deposit(coins:Double) extends Operation {
  
   def multipier:Integer = 1
      
   def value:Double  = coins;
  
}

class Widthraw(coins:Double) extends Operation {
  
   def multipier:Integer = -1
      
   def value:Double  = coins;
  
}


object Operation {
  
  def apply(coins:Double) = coins match{
    case d : Double if (coins > 0) => new Deposit(coins)
    case w : Double if (coins < 0)=> new Widthraw(coins)
    case _ => None
  }
  
}