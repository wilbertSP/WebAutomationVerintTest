package com.verint.stepDefinitions;

import com.verint.pages.SearchPage;
import com.verint.utils.manager.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.sql.Driver;

public class SearchSteps {

    private final DriverManager driverManager;
    private WebDriver driver;
    private final SearchPage searchPage;
    public SearchSteps() {
        this.searchPage = new SearchPage();
        this.driverManager = new DriverManager();
    }

    @Before
    public void settingUp() {
        this.driver = driverManager.getWebDriver();
    }

    @After
    public void closingDown() {
        driverManager.closeDriver();
    }

    @Given("User is on Verint website")
    public void userIsOnVerintWebsite() {
        driver.get("https://www.verint.com/");
    }

    @Given("User is on the search page")
    public void userIsOnTheSearchPage() {
        driver.navigate().to("https://www.google.com/");
    }

    @When("User enter the term {string}")
    public void userEnterTheTerm(String arg0) {
        driver.navigate().to("https://www.youtube.com/");
    }

    @Then("User sees an article that mentions the term {string}")
    public void userSeesAnArticleThatMentionsTheTerm(String arg0) {
        driver.quit();
    }
}
