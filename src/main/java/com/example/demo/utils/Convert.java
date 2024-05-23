package com.example.demo.utils;

import com.google.gson.Gson;

public class Convert {
    private Convert() {
        // private constructor to hide the implicit public one
    }

    public static String convertToJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T convertJsonToObject(String jsonString, Class<T> tClass) {
        return new Gson().fromJson(jsonString, tClass);
    }
}
