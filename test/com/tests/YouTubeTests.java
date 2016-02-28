package com.tests;

import com.pages.HomePage;
import com.pages.SearchResultsPage;
import com.pages.VideoPage;
import com.utils.ListenerClass;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.IOException;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;


/**
 * Created by erol on 13.2.2016.
 */

@Listeners({ ListenerClass.class })
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
        resultsPage.userName().shouldHave(text("ChessNetwork"));
        String FirstSearchResultTitle = resultsPage.getFirstVideoTitle();
        resultsPage.clickFirstResult();
        VideoPage videoPage = resultsPage.clickFirstResult();
        videoPage.videoTitle().shouldHave(text(FirstSearchResultTitle));

    }


    @Title("Wrong assertion")
    @Features("Search users and videos")
    @Description("Some description")
    @Severity(SeverityLevel.BLOCKER)
    @Step("This is going to Fail!")
    @Issue("FB-1907")
    @TestCaseId("TMS-123")
    @Stories("I would like to search some educational videos on YouTube")
    @Test
    public void searchFailTest() throws IOException {
        HomePage homePage = open("https://www.youtube.com/", HomePage.class);
        SearchResultsPage resultsPage = homePage.searchFor("chessnetwork checkmated");
        saveTextLog("User name : ", resultsPage.getUserName());
        resultsPage.userName().shouldHave(text("Erol"));
        String FirstSearchResultTitle = resultsPage.getFirstVideoTitle();
        resultsPage.clickFirstResult();
        VideoPage videoPage = resultsPage.clickFirstResult();
        videoPage.videoTitle().shouldHave(text(FirstSearchResultTitle));

    }

    @Title("Checking Search Result")
    @Features("Search user")
    @Description("Some description")
    @Severity(SeverityLevel.CRITICAL)
    @Issue("FB-1907")
    @TestCaseId("TMS-123")
    @Stories("I would like to search users on youtube")
    @Test
    public void searchPassTest() throws IOException {
        HomePage homePage = open("https://www.youtube.com/", HomePage.class);
        SearchResultsPage resultsPage = homePage.searchFor("chessnetwork checkmated");
        saveTextLog("User name : ", resultsPage.getUserName());
        resultsPage.userName().shouldHave(text("ChessNetwork"));

    }

    @Test(enabled = false)
    public void notReadyTest() throws IOException {
        HomePage homePage = open("https://www.youtube.com/", HomePage.class);
        SearchResultsPage resultsPage = homePage.searchFor("chessnetwork checkmated");
        saveTextLog("User name : ", resultsPage.getUserName());
        resultsPage.userName().shouldHave(text("Erol"));
        String FirstSearchResultTitle = resultsPage.getFirstVideoTitle();
        resultsPage.clickFirstResult();
        VideoPage videoPage = resultsPage.clickFirstResult();
        videoPage.videoTitle().shouldHave(text(FirstSearchResultTitle));

    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult testResult) throws IOException{
    }

    @Attachment(value = "Text", type = "text/plain")
    public static String saveTextLog(String attachName, String message) {
        return message;
    }

}
