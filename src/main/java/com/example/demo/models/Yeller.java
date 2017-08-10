package com.example.demo.models;

public class Yeller {
  
  String secretmessage;
  
  public Yeller(String message) {
	  secretmessage = message;
  }


  public String yell() {
	  return secretmessage.toUpperCase();
  }
}
