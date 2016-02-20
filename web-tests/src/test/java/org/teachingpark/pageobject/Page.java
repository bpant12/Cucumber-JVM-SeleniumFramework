package org.teachingpark.pageobject;

import org.openqa.selenium.WebElement;
import org.teachingpark.Utils.TestWebDriver;

public abstract class Page {

    public TestWebDriver testWebDriver;

    protected Page(TestWebDriver driver) {
        this.testWebDriver = driver;
    }
    public void sendKeys(WebElement locator, String value) {
        int length = testWebDriver.getAttribute(locator, "value").length();
        for (int i = 0; i < length; i++)
            locator.sendKeys("\u0008");
        locator.sendKeys(value);
    }

}