package com.techprowed.utilities;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonUtil {
    private static ObjectMapper mapper = new ObjectMapper();

    public JsonUtil() {
    }

    public static <T> T convertJsonToJava(String json, Class<T> cls) {
        Object javaResult = null;

        try {
            javaResult = mapper.readValue(json, cls);
        } catch (IOException var4) {
            System.err.println("json datası javaya dönüştürülemedi");
        }

        return (T) javaResult;
    }


}
