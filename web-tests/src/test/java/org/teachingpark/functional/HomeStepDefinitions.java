package org.teachingpark.functional;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.teachingpark.Utils.ManageTest;
import org.teachingpark.pageobject.HomePage;
import org.teachingpark.properties.ApplicationConfig;

import java.io.IOException;
import java.sql.SQLException;

public class HomeStepDefinitions extends ManageTest {

	ApplicationConfig objApplication;
    @Before
    public void setUp() throws Exception {
    	objApplication = ApplicationConfig.getInstance();
        super.setup(objApplication.getImplicitTime(),objApplication.getBrowser());
       }

    @Given("^I access google search page$")
    public void accessGoogleSearch() throws IOException {
        HomePage homePage = new HomePage(testWebDriver);
        homePage.accessHomePage();
    }

    @When("^I search \"([^\"]*)\"$")
    public void searchText(String searchText) throws  Exception{
        HomePage homePage = new HomePage(testWebDriver);
        homePage.setSearchField(searchText);
    }

    @And("^I submit search$")
    public void submitSearch() throws  Exception{
        HomePage homePage = new HomePage(testWebDriver);
        homePage.submitSearch();
    }

    @Then("^I see link (\\d+) as \"([^\"]*)\"$")
    public void verifyFirstLink(int linkNumber,String linkText) throws  Exception{
        HomePage homePage = new HomePage(testWebDriver);
        Assert.assertEquals(homePage.getSearchResult(linkNumber - 1), linkText);
    }

    @After
    public void tearDown(Scenario scenario) throws SQLException {
        try {
            if (scenario.isFailed()) {
                scenario.embed(testWebDriver.takeScreenShot(), "image/png");
            }
        } finally {
            testWebDriver.quitDriver();
        }
    }
}
