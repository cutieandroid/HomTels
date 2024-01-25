package com.harshmali.hotelservice.Exceptions;

public class ResourceNfException extends RuntimeException{

   public ResourceNfException(){
       super("Resource not found");
   }

   public ResourceNfException(String message){
       super(message);
   }

}
