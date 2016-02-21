package com.pages;

import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by erol on 13.2.2016.
 */
public class HomePage {

    public SearchResultsPage searchFor(String text) {
        $(By.name("search_query")).val(text).pressEnter();
        return page(SearchResultsPage.class);
    }
}
