package com.verint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SearchPage extends InteractionUtil {
    /**
     * A class used to get all the web element for the automation, and
     * also create a simplified method to interact with the page by extending
     * from InteractionUtil class
     */

    public SearchPage(WebDriver driver) {
        setDriver(driver);
    }

    // Object on the main website page
    private final By searchButton = By.cssSelector("#site-header > div > div.site-header__container > div > div.site-header__wrap.flex.scroll--mobile > ul > li.site-header__item.site-header__item--search.site-header__item--desktop > button");
    private final By searchInput = By.id("search-input--desktop");
    private final By articleLists = By.cssSelector(".site-header__wrap .search__results > .search__items article > a > span");
    private final By searchQuery = By.cssSelector(".site-header__wrap .search__query");

    // Method that interact with the page
    public void clickSearch() {
        clickElement(searchButton);
    }
    public void setSearchInput(String input) {
        setElement(searchInput, input);
    }
    public boolean validateArticle(String text) {
        validateText(searchQuery, text);
        return validateElementsText(articleLists, text);
    }
}
