package com.devops.e2eTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import java.io.File;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaywrightTests {
    private static Page page;
    private static Browser browser;
    private static Playwright playwright;
    boolean isCloud = false;

    @BeforeEach
    public void beforeEach(){
        String workspace = System.getenv("WORKSPACE");

        if (workspace != null && new File(workspace).exists()) {
            System.out.println("Cloud environment");
            isCloud = true;
        } else {
            System.out.println("Local environment");
        }
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
            );
            page = browser.newPage();
    }


    @DisplayName("Test 1")
    @Test
    public void test1(){
        Assumptions.assumeFalse(isCloud, "Testler cloud ortamında çalıştırılmıyor.");

        page.navigate("http://docker.com");
            System.out.println(page.title());
        assertEquals("Docker: Accelerated Container Application Development",
                page.title());

    }

    @DisplayName("Test 2")
    @Test
    public void test2(){
        Assumptions.assumeFalse(isCloud, "Testler cloud ortamında çalıştırılmıyor.");

        page.navigate("http://kubernetes.io");
        System.out.println(page.title());
        assertEquals("Kubernetes",
                page.title());

    }

    @AfterEach
    public void afterEach(){
        page.close();
        playwright.close();
    }


}
