package com.tests;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import com.pages.HomePage;
import com.pages.SearchResultsPage;
import com.pages.VideoPage;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.File;
import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.sleep;


/**
 * Created by erol on 13.2.2016.
 */

public class YouTubeTests {

    @Title("Erol Selitektay YouTube Demo")
    @Features("Search users and videos")
    @Description("Some description")
    @Severity(SeverityLevel.BLOCKER)
    //@Step("some step")
    @Issue("FB-1907")
    @TestCaseId("TMS-123")
    @Stories("I would like to search some educational videos on YouTube")
    @Test
    public void searchTest() throws IOException {
        HomePage homePage = open("https://www.youtube.com/", HomePage.class);
        SearchResultsPage resultsPage = homePage.searchFor("chessnetwork checkmated");
        saveTextLog("User name : ", resultsPage.getUserName());
        resultsPage.userName().shouldHave(text("Erol"));
        String FirstSearchResultTitle = resultsPage.getFirstVideoTitle();
        resultsPage.clickFirstResult();
        VideoPage videoPage = resultsPage.clickFirstResult();
        videoPage.videoTitle().shouldHave(text(FirstSearchResultTitle));

        sleep(5000);
    }

    @AfterTest
    public void tearDown() throws IOException{
        saveTextLog("User name : ", "After Testin icinde screenshot dan once");
        screenshot();
        System.out.println("after test run");
    }

    @Attachment(value = "Text", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }


}
