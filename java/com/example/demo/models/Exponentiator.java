package com.example.demo.models;

public class Exponentiator {

	   private double result;		
	   public Exponentiator(double first, double second) {
		   result = Math.pow(first, second);
	   }
   
   public double exponentiate() {
	   return result;
   } 
}
