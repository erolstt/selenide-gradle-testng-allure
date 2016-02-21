package com.pages;

/**
 * Created by erol on 14.2.2016.
 */

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
public class VideoPage {

    public SelenideElement videoTitle(){
        return $(".watch-title");
    }
}
