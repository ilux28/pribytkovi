package ru.pribytkov.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.pribytkov.models.Item;
import java.io.File;
import java.io.IOException;

public class Converter {
    private final static String baseFile = "item.json";

    public static String toJSON(Item item) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(new File(baseFile), item);
        System.out.println("json created!");
        //String itemJson = baseFile;
        return baseFile;
    }

    public static Item toJavaOject() throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.readValue(new File(baseFile), Item.class);
    }
}
