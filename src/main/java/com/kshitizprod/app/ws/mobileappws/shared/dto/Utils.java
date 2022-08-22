package com.kshitizprod.app.ws.mobileappws.shared.dto;

import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Random;

@Component
public class Utils {

    private final Random RANDOM= new SecureRandom();
    private final String ALPHABET = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghujiklmnoprqstuvwxyz";
    public String generateUserId(int length){
        return generateRandomString(length);
    }
    private String generateRandomString(int length){
        StringBuilder returnValue= new StringBuilder();
        for(int i=0;i<length;i++){
            returnValue.append(ALPHABET.charAt(RANDOM.nextInt(ALPHABET.length())));
        }
        return new String(returnValue);
    }
}
