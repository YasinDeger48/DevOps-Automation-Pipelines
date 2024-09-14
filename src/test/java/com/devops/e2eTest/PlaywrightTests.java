package com.devops.e2eTest;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlaywrightTests {
    private static Page page;
    private static Browser browser;
    private static Playwright playwright;
    @BeforeEach
    public void beforeEach(){
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(true)
            );
            page = browser.newPage();
    }


    @DisplayName("Test 1")
    @Test
    public void test1(){
            page.navigate("http://docker.com");
            System.out.println(page.title());
        assertEquals("Docker: Accelerated Container Application Development",
                page.title());

    }

    @DisplayName("Test 2")
    @Test
    public void test2(){
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
