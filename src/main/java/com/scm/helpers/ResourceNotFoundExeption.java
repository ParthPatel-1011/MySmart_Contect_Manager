package com.scm.helpers;

public class ResourceNotFoundExeption extends RuntimeException {

    public ResourceNotFoundExeption(String message){
        super(message);
    }
    public ResourceNotFoundExeption(){
        super("Resource not found");
    }

}
