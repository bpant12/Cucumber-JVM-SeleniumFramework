package org.teachingpark.Utils;

import org.openqa.selenium.remote.UnreachableBrowserException;

import java.io.File;
import java.io.IOException;

import static java.lang.System.getProperty;

public class ManageTest {
    protected static String baseUrlGlobal;
    protected static String DOWNLOAD_FILE_PATH;
    protected static TestWebDriver testWebDriver;

    private static DriverFactory driverFactory = new DriverFactory();
    private static final String DEFAULT_BROWSER = "chrome";
    private static final String DEFAULT_BASE_URL = "http://localhost:9091/";

    public void setup(int time) throws Exception {
        String browser = getProperty("browser", DEFAULT_BROWSER);
        baseUrlGlobal = getProperty("baseurl", DEFAULT_BASE_URL);

        if (testWebDriver == null) {
            loadDriver(time,browser);
            testWebDriver.implicitTime(time);
            addTearDownShutDownHook();
        }

        if (getProperty("os.name").startsWith("Windows"))
            DOWNLOAD_FILE_PATH = "C:\\Users\\Downloads";
        else
            DOWNLOAD_FILE_PATH = new File(System.getProperty("user.dir")).getParent();
    }
    
    public void setup(int time,String browser) throws Exception {
       baseUrlGlobal = getProperty("baseurl", DEFAULT_BASE_URL);

        if (testWebDriver == null) {
            loadDriver(time,browser);
            testWebDriver.implicitTime(time);
            addTearDownShutDownHook();
        }

        if (getProperty("os.name").startsWith("Windows"))
            DOWNLOAD_FILE_PATH = "C:\\Users\\Downloads";
        else
            DOWNLOAD_FILE_PATH = new File(System.getProperty("user.dir")).getParent();
    }

    protected void addTearDownShutDownHook() {
        Runtime.getRuntime().addShutdownHook(new Thread() {
            public void run() {
                    try{
                        testWebDriver.quitDriver();
                    }
                    catch (UnreachableBrowserException e) {
                        e.printStackTrace();
                    }
            }
        });
    }

    protected void loadDriver(int timeOut,String browser) throws InterruptedException, IOException {
        testWebDriver = new TestWebDriver(driverFactory.loadDriver(timeOut,browser));
    }
}
