package com.roytuts.pretify.json.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonStringPrettifyJacksonApp {

    public static void main(String[] args) throws IOException {
        // ObjectMapper mapper = new ObjectMapper()
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        final String inputJson = "{\"one\":\"AAA\",\"two\":[\"BBB\",\"CCC\"],\"three\":{\"four\":\"DDD\",\"five\":[\"EEE\",\"FFF\"]}}";

        // System.out.println(mapper.writerWithDefaultPrettyPrinter().writeValueAsString(mapper.readTree(inputJson)));
        System.out.println(mapper.writeValueAsString(mapper.readTree(inputJson)));

        Path path = Paths.get("input.json");

        String str = new String(Files.readAllBytes(path));

        //Files.write(Paths.get("output.json"),
        //        mapper.writerWithDefaultPrettyPrinter().writeValueAsBytes(mapper.readTree(str)));
        Files.write(Paths.get("output.json"), mapper.writeValueAsBytes(mapper.readTree(str)));
    }

}
