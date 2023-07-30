package org.core;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class JsonReader {

    public JsonObject readConfigData() throws IOException {
        File file = new File("data.json");
        String json = new String(Files.readAllBytes(file.toPath()));
        return new Gson().fromJson(json, JsonObject.class);

    }

    public JsonObject readDeviceCapabilitiesFile() throws IOException {
        File file = new File("capabilities.json");
        String json = new String(Files.readAllBytes(file.toPath()));
        return new Gson().fromJson(json, JsonObject.class);
    }
}