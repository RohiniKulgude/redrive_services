package com.hackathon.redrive_rest;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.core.io.ClassPathResource;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Util {

    public static ObjectMapper mapper = new ObjectMapper();
    private static final String FILE_NAME = "C:\\Users\\malir\\Desktop\\redrive_rest\\src\\main\\resources\\d_auth.json";

    public static String readJsonFromFile(String fileName) throws IOException {
        try (BufferedReader reader = new BufferedReader(
                new FileReader(new File(FILE_NAME)))) {
            StringBuilder builder = new StringBuilder();
            String line = reader.readLine();
            while (line != null) {
                builder.append(line);
                line = reader.readLine();
            }
            return builder.toString();
        }
    }

    public static JsonNode getJsonNode(String fileName) throws IOException {
        return mapper.readTree(readJsonFromFile(fileName));
    }
}
