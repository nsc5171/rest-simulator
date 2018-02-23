package com.nsc5171.myprojects.utils;

import org.springframework.stereotype.Component;
import org.springframework.util.Base64Utils;

@Component
public class EncodeDecodeUtil {

    public String encode(String input) {
        if (input != null) {
            return Base64Utils.encodeToString(input.getBytes());
        } else {
            throw new IllegalArgumentException("String to be encoded cannot be null!!!");
        }
    }

    public String decode(String input) {
        if (input != null) {
            return new String(Base64Utils.decodeFromString(input));
        } else {
            throw new IllegalArgumentException("String to be decoded cannot be null!!!");
        }
    }

}
