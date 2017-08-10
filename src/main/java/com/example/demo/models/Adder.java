package com.example.demo.models;

public class Adder {

//	   int secret1;
//	   double secret2;
//	simplified below
	   private double sum;
//	make it private so that the controller can't mess with it
//	but since we're encapsulated, that's okay
		
	   public Adder(int first, double second) {
//		   secret1 = first;
//		   secret2 = second;
		   sum = first + second;
	   }
   
   public double calculate() {
//	   return secret1 + secret2;
	   return sum;
   } 
}
