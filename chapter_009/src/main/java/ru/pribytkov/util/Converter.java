package ru.pribytkov.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.pribytkov.models.Item;
import java.io.File;
import java.io.IOException;

public class Converter {
    //private final static String baseFile = "item.json";

    public static String toJSON(Item item) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        String sendJson = mapper.writeValueAsString(item);
        System.out.println("json created!");
        //String itemJson = baseFile;
        return sendJson;
    }

    public static Item toJavaObject(String jsonString) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(jsonString, Item.class);
    }
}
