package utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class JsonMapper {
    private ObjectMapper objectMapper = new ObjectMapper();

    public void serializeJson(File file, Object o) {
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        try {
            objectMapper.writeValue(file, o);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void deserializeJson(File file, Class clazz){
        try {
            objectMapper.readValue(file, clazz);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
