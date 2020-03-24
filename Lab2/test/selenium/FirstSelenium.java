package selenium;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirstSelenium {




    public static void main(String[] args) {

        String driverPath = System.getProperty("user.dir") + "/src/resources/driver/geckodriver.exe";
        System.setProperty("webdriver.gecko.driver", driverPath);
        WebDriver driver = new FirefoxDriver();

        String baseUrl = "http://103.120.226.190/selenium-demo/git-repo";

        driver.get(baseUrl);

        WebElement userNum = driver.findElement(By.name("user_number"));
        userNum.sendKeys("userName");
        WebElement passName = driver.findElement(By.name("password"));
        passName.sendKeys("admin");

        WebElement a = driver.findElement(By.xpath("/html/body/div/div/div/div/div/div/div[2]/div/form/div[5]"));
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
//        if (actualTitle.contentEquals(expectedTitle)) {
//            System.out.println("Test Passed!");
//        } else {
//            System.out.println("Test Failed");
//        }

        //close Fire fox
        driver.close();
    }

}
