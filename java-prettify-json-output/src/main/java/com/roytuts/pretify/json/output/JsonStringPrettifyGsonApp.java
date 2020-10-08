package com.roytuts.pretify.json.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParser;

public class JsonStringPrettifyGsonApp {

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        final String inputJson = "{\"one\":\"AAA\",\"two\":[\"BBB\",\"CCC\"],\"three\":{\"four\":\"DDD\",\"five\":[\"EEE\",\"FFF\"]}}";

        System.out.println(gson.toJson(JsonParser.parseString(inputJson)));

        Path path = Paths.get("input.json");

        String str = new String(Files.readAllBytes(path));

        Files.write(Paths.get("output.json"), gson.toJson(JsonParser.parseString(str)).getBytes());
    }

}
