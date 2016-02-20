package com.teachingpark.pageobject;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

import com.teachingpark.Utils.TestWebDriver;
import com.teachingpark.properties.ApplicationConfig;

import java.io.IOException;
import java.util.List;


public class HomePage extends Page {

    @FindBy(name = "q")
    private static WebElement searchField;


    @FindBy(how = How.XPATH, using = "//h3[@class='r']")
    private static List<WebElement> searchResultList=null;

    private String HOME_PAGE_URL = ApplicationConfig.getInstance().getURL();

    public HomePage(TestWebDriver driver) throws IOException {
        super(driver);

        PageFactory.initElements(new AjaxElementLocatorFactory(TestWebDriver.getDriver(), ApplicationConfig.getInstance().getImplicitTime()), this);
        testWebDriver.setImplicitWait(10);
    }

    public void accessHomePage(){
        testWebDriver.setBaseURL(HOME_PAGE_URL);
        testWebDriver.waitForElementToAppear(searchField);
    }

    public void setSearchField(String searchText){
        searchField.clear();
        searchField.sendKeys(searchText);

    }

    public void submitSearch() throws InterruptedException {
    	searchField.submit();
        Thread.sleep(5000);
    }

    public String getSearchResult(int listNumber){
        return searchResultList.get(listNumber).getText();
    }

}