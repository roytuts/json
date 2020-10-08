package com.roytuts.pretify.json.output;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.json.JSONObject;

public class JsonStringPrettifyJSONApp {

    public static void main(String[] args) throws IOException {
        final String inputJson = "{\"one\":\"AAA\",\"two\":[\"BBB\",\"CCC\"],\"three\":{\"four\":\"DDD\",\"five\":[\"EEE\",\"FFF\"]}}";

        System.out.println(new JSONObject(inputJson).toString(4));

        Path path = Paths.get("input.json");

        String str = new String(Files.readAllBytes(path));

        Files.write(Paths.get("output.json"), new JSONObject(str).toString(4).getBytes());
    }

}
