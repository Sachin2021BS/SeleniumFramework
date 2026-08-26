package com.utility;

import com.constants.Env;
import com.google.gson.Gson;
import com.ui.pojo.Config;
import com.ui.pojo.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Jsonutility {

    public static Environment readJsonFile(Env QA) {

        File jsonFile = new File(System.getProperty("user.dir")+ "/config/config.json");
        Gson gson = new Gson();
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(jsonFile);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        Config config = gson.fromJson(fileReader, Config.class);
        Environment environment = config.getEnvironments().get("QA");
        System.out.println(environment.getUrl());

        return environment;

    }
}
