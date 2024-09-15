package com.devops.e2eTest;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SeleniumTests {
    private final ChromeOptions chromeOptions = new ChromeOptions();
    private boolean isCloud = false;
    WebDriver driver;
    {
        String workspace = System.getenv("WORKSPACE");

        if (workspace != null && new File(workspace).exists()) {
            System.out.println("Cloud environment");
            isCloud = true;
        } else {
            System.out.println("Local environment");
        }
        if(!isCloud) {
            chromeOptions.addArguments("--headless=new");
            chromeOptions.addArguments("--start-maximized");
            //driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), chromeOptions);
            driver = new ChromeDriver(chromeOptions);
        }

    }
    @DisplayName("Selenium Terraform Test")
    @Test
    public void testTerraform(){
        if(!isCloud) {
            driver.get("https://www.terraform.io/");
            String actualTitle = driver.getTitle();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.titleContains("Terraform"));
            assertEquals("Terraform by HashiCorp", actualTitle);
            driver.quit();
        }
    }

    @DisplayName("Selenium Ansible Test")
    @Test
    public void testAnsible() {
        if (!isCloud) {
            driver.get("https://www.ansible.com/");
            String actualTitle = driver.getTitle();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
            wait.until(ExpectedConditions.titleContains("Ansible"));
            assertEquals("Homepage | Ansible Collaborative", actualTitle);
            driver.quit();
        }
    }

}
