package com.verint.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
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
    // private final By searchButton = By.cssSelector("#site-header > div > div.site-header_container > div > div.site-header_wrap.flex.scroll--mobile > ul > li.site-header__item.site-header__item--search.site-header__item--desktop > button");
    private final By searchButtonDesktop = By.cssSelector(".site-header__item--desktop .site-header__button--search");
    private final By searchButtonMobile = By.cssSelector(".site-header__item--mobile .site-header__button--search");
    private final By searchInputDesktop = By.id("search-input--desktop");
    private final By searchInputMobile = By.id("search-input--mobile");
    //private final By articleLists = By.cssSelector(".site-header_wrap .searchresults > .search_items article > a > span");
    private final By articleLists = By.cssSelector("article > a > span");
    private final By searchQuery = By.cssSelector(".site-header__wrap .search__query");

    // Methods that interact with the page
    public void clickSearch() {
        try {
            clickElement(searchButtonMobile);
        } catch(TimeoutException e) {
            System.err.println("Search button is not on mobile section");
            try {
                clickElement(searchButtonDesktop);
            } catch(TimeoutException err) {
                err.printStackTrace();
            }
        }
    }

    public void setSearchInput(String input) {
        try {
            setElement(searchInputMobile, input);
        } catch(TimeoutException e) {
            System.err.println("Search input is not on mobile section");
            try {
                setElement(searchInputDesktop, input);
            } catch(TimeoutException err) {
                err.printStackTrace();
            }
        }
    }

    public boolean validateArticle(String text) {
        validateText(searchQuery, text);
        return validateElementsText(articleLists, text);
    }
}