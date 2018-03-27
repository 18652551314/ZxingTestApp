package com.example.android.rxjava;

public class Contributor {
  
    public String login;  
    public int contributions;  
  
    @Override  
    public String toString() {  
        return login + ", " + contributions;  
    }  
}  