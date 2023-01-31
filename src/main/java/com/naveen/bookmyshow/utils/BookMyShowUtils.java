package com.naveen.bookmyshow.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class BookMyShowUtils {
   public BookMyShowUtils()
    {

    }

    public static ResponseEntity<String> responseEntity(String responseMessage, HttpStatus httpStatus)
    {
        return  new ResponseEntity<>("{\"message\":\""+responseMessage+"\"}",httpStatus);
    }
}
