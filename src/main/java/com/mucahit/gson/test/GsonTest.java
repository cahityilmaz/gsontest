package com.mucahit.gson.test;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author mucahit.yilmaz
 */
public class GsonTest {

    static Type type = new TypeToken<Configuration>() {
    }.getType();

    public static void main(String[] args) {
        readJson();
//        writeJson();
    }

    static void readJson() {
        try {
            Gson gson = new GsonBuilder().registerTypeAdapter(type, new JsonDeserializer<Configuration>() {
                @Override
                public Configuration deserialize(JsonElement je, Type type, JsonDeserializationContext jdc) throws JsonParseException {
                    List<AddressSpace> list;
                    JsonObject configurationObject = je.getAsJsonObject();
                    Gson gson = new Gson();
                    Configuration configuration = gson.fromJson(configurationObject, Configuration.class);
                    JsonObject objectMap = configurationObject.get("objectMap").getAsJsonObject();
                    JsonArray spaceList = objectMap.get("space.list").getAsJsonArray();
                    list = gson.fromJson(spaceList, new TypeToken<List<AddressSpace>>() {
                    }.getType());
                    configuration.putValueToMap("space.list", list);

                    return configuration;
                }
            }).create();
            Configuration config = gson.fromJson(new FileReader(new File("C:\\new.json")), type);
            System.out.println("");
        } catch (FileNotFoundException ex) {
            Logger.getLogger(GsonTest.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    static void writeJson() {
        Configuration configuration = new Configuration("Config 1");
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        String toJson = gson.toJson(configuration, type);
        File file = new File("C:\\new.json");
        try {
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write(toJson);
            fileWriter.flush();
        } catch (IOException ex) {
            Logger.getLogger(GsonTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
