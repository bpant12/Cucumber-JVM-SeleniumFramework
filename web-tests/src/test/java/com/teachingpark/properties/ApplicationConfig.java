package com.teachingpark.properties;

import java.io.File;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;

import com.teachingpark.constant.AppConstant;

public class ApplicationConfig {

	Properties properties;
	private static ApplicationConfig instance;
      
      private ApplicationConfig() throws IOException {
    	  String PROPS_FILE_NAME = AppConstant.CONFIG_PATH;
    	  properties = new Properties();
          File configFile = null;
          configFile = new File(PROPS_FILE_NAME);
          properties.load(FileUtils.openInputStream(configFile));
      }
      
      public static ApplicationConfig getInstance() throws IOException {
          if (instance == null) {
              instance = new ApplicationConfig();
             }
          return instance;
      }
      
      public String getURL(){
    	 return  properties.getProperty("app_url");
      }
      
      public int getImplicitTime(){
     	 return  Integer.parseInt(properties.getProperty("implicit_timeout"));
       }

	public String getBrowser() {
		 return  properties.getProperty("browser");
	}
      
}
