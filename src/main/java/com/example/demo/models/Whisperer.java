package com.example.demo.models;

public class Whisperer {
	  
	  String secretmessage;
	  
	  public Whisperer(String message) {
		  secretmessage = message;
	  }


	  public String whisper() {
		  return secretmessage.toLowerCase();
	  }
	}
