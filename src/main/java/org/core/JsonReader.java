package org.core;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonReader {

    public JsonObject readTestData() throws IOException {
        File file = new File("data.json");
        String json = new String(Files.readAllBytes(file.toPath()));
        return new Gson().fromJson(json, JsonObject.class);
    }

    public JsonObject readCapabilities() throws IOException {
        File file = new File("deviceCapabilities.json");
        String json = new String(Files.readAllBytes(file.toPath()));
        return new Gson().fromJson(json, JsonObject.class);
    }
}