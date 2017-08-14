package com.example.demo.models;

public class Adder {

//	   int secret1;
//	   double secret2;
//	simplified below
	   private double result;
//	make it private so that the controller can't mess with it
//	but since we're encapsulated, that's okay
		
	   public Adder(double first, double second) {
//		   secret1 = first;
//		   secret2 = second;
		   result = first + second;
	   }
   
   public double add() {
//	   return secret1 + secret2;
	   return result;
    }

}
