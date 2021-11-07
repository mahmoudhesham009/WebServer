package com.mahmoudH.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Json {
    private static ObjectMapper objectMapper;
    static {
        objectMapper=new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

    public static <A> A parse(String json,Class<A> aClass) throws JsonProcessingException {
        return objectMapper.treeToValue(objectMapper.readTree(json),aClass);
    }
}
