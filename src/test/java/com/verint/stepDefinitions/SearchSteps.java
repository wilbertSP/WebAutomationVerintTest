package com.verint.stepDefinitions;

import com.verint.pages.SearchPage;
import com.verint.utils.DriverManager;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class SearchSteps {
    private final DriverManager driverManager;
    private WebDriver driver;
    private SearchPage searchPage;
    public SearchSteps() {
        this.driverManager = new DriverManager();
    }

    @Before
    public void settingUp() {
        this.driver = driverManager.getWebDriver();
        this.searchPage = new SearchPage(driver);
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
        searchPage.clickSearch();
    }

    @When("User enter the term {string}")
    public void userEnterTheTerm(String arg0) {
        searchPage.setSearchInput(arg0);
    }

    @Then("User sees an article that mentions the term {string}")
    public void userSeesAnArticleThatMentionsTheTerm(String arg0) {
        Assert.assertTrue("None of the article's title contains \"" + arg0 +"\"",
                searchPage.validateArticle(arg0));
    }
}
