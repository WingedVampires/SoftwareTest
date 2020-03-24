package com.lsc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;


public class FireboxSeleium {
    private String userName;
    private String password;
    private WebDriver driver;
    private String baseUrl;

    FireboxSeleium() {
        String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        driver = new FirefoxDriver();
    }

    public FireboxSeleium setUser(String userName, String password) {
        this.userName = userName;
        this.password = password;

        return this;
    }

    public FireboxSeleium setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;

        return this;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public FireboxSeleium load() {
        driver.get(baseUrl);

        return this;
    }

    public String GetAndJudgeResult() {
        WebElement userNum = driver.findElement(By.name("user_number"));
        WebElement passName = driver.findElement(By.name("password"));
        WebElement submitName = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[3]/input"));


        passName.sendKeys(password);
        userNum.sendKeys(userName);
        submitName.click();

        WebElement message = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]/code"));
        String result = message.getAttribute("innerHTML");

        return result;
    }

    public void close() {
        driver.close();
    }
}
