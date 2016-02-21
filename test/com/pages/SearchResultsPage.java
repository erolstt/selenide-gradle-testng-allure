package com.pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

/**
 * Created by erol on 13.2.2016.
 */
public class SearchResultsPage {
    public String getUserName(){
        return $("div.yt-lockup-byline a").getText();
    }

    public SelenideElement userName(){
        return $("div.yt-lockup-byline a");
    }

    public  String getFirstVideoTitle(){
        return $("ol.item-section li:nth-of-type(1) h3 a").getText();
    }

    public UserPage clickSearchResult(){
        $("div.yt-lockup-byline a").click();
        return page(UserPage.class);
    }

    public VideoPage clickFirstResult(){
        $("ol.item-section li:nth-of-type(1)").click();
        return page(VideoPage.class);
    }
}
