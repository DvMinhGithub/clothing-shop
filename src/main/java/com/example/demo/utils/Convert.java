package com.example.demo.utils;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Convert {
    public static String convertToJson(Object object) {
        return new Gson().toJson(object);
    }

    public static <T> T convertJsonToObject(String jsonString, Class<T> tClass) {
        return new Gson().fromJson(jsonString, tClass);
    }

    public static List<Long> convertJsonToListLong(String json) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode node = mapper.readTree(json);
        List<Long> list = new ArrayList<>();
        for (JsonNode element : node) {
            list.add(element.asLong());
        }
        return list;
    }
}
