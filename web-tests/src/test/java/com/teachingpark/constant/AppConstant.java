package com.teachingpark.constant;

import java.io.File;

import static java.lang.System.getProperty;

public interface AppConstant {

    File PARENT_DIR = new File(getProperty("user.dir"));
    String SEPARATOR = System.getProperty("file.separator");
    String RESOURCE_FOLDER = PARENT_DIR.getPath() + SEPARATOR + "src" + SEPARATOR + "test" + SEPARATOR + "resources";
    String CONFIG_PATH = RESOURCE_FOLDER + SEPARATOR + "config" + SEPARATOR + "config.properties";
}
