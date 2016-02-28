package com.utils;

import com.codeborne.selenide.Screenshots;
import com.google.common.io.Files;
import org.testng.ITestResult;
import org.testng.TestListenerAdapter;
import ru.yandex.qatools.allure.annotations.Attachment;

import java.io.File;
import java.io.IOException;

/**
 * Created by erol on 28.2.2016.
 */
public class ListenerClass extends TestListenerAdapter {

    @Attachment(type = "image/png")
    public byte[] screenshot() throws IOException {
        File screenshot = Screenshots.getLastScreenshot();
        return Files.toByteArray(screenshot);
    }
    @Override
    public void onTestFailure(ITestResult testResult){
        try {
            screenshot();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}