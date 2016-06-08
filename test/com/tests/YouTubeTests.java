package com.tests;

import com.pages.HomePage;
import com.pages.SearchResultsPage;
import com.pages.VideoPage;
import com.utils.ListenerClass;
import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessRead;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.*;
import ru.yandex.qatools.allure.model.SeverityLevel;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static com.codeborne.selenide.WebDriverRunner.url;
import static org.testng.Assert.assertEquals;


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
    @Test(enabled = false)
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
    @Test(enabled = false)
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
    @Test(enabled = false)
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

    @Test
    public void twitterTest(){
        open("http://www.ntvspor.net/");
        $(By.cssSelector("#socialBarWrapper .fa.fa-twitter")).click();
        switchTo().window("NTV Spor (@ntvspor) | Twitter");
        $(By.id("search-query")).val("EROL Selitektay");
        sleep(1000);
    }

    @Test
    public void pdfTest() throws IOException {
        open("http://www.axmag.com/download/pdfurl-guide.pdf");
        sleep(5000);
        URL curUrl = new URL(url());
        System.out.println(curUrl);
        PDDocument pd;
        BufferedInputStream fileToParse = new BufferedInputStream(curUrl.openStream());
        pd = PDDocument.load(fileToParse);
        PDFTextStripper stripper = new PDFTextStripper();
        String plainText = stripper.getText(pd);
        System.out.println(plainText);
    }

    @Test
    public void fileDownloadTest() throws FileNotFoundException {
        open("http://chessproblem.my-free-games.com/chess/games/Download-PGN.php");
        File downloadedFile = $(By.cssSelector("a[href=\"../../PGN/Adams.zip\"]")).download();
        assertEquals("Adams.zip", downloadedFile.getName());

    }



}
