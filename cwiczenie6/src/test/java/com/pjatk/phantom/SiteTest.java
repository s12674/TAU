package com.pjatk.phantom;

/**
 * Created by Mateusz on 03.04.2017.
 */

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import com.pjatk.phantom.OsValidator;
import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;


public class SiteTest {
    private static OsValidator osValidator;
    private static WebDriver driver;
    private static String pathToSS;
    WebElement element;
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

    @BeforeClass
    public static void driverSetup() {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability("takesScreenshot", true);
        if(OsValidator.isWindows()){
            caps.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    "phantomjs.exe"
            );
        }
        else{
            caps.setCapability(
                    PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY,
                    "target/phantomjs"
            );
        }

        driver = new PhantomJSDriver(caps);
    }

    @Before
    public void setUp() throws Exception {



        if(OsValidator.isWindows()){
            pathToSS = "D:\\PJWSTK\\TAU\\cwiczenie6\\ss\\";
        }
        else{
            pathToSS = "target/";
        }
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().clear();
    }

    @Test
    public void loginFailed() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        driver.findElement(By.name("user")).sendKeys("wronglogin");
        driver.findElement(By.name("haslo")).sendKeys("wronglogin");
        driver.findElement(By.id("zaloguj")).click();
        assertEquals(driver.findElement(By.id("failed")).isDisplayed(), true);
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        assertNotNull(screenshot);
        FileUtils.copyFile(screenshot, new File(pathToSS + "nieudane.png"));
        System.out.println("LoginFailed");
    }

    @Test
    public void loginPassed() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("haslo")).sendKeys("admin");
        driver.findElement(By.id("zaloguj")).click();
        assertEquals(driver.findElement(By.id("success")).isDisplayed(), true);
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        assertNotNull(screenshot);
        FileUtils.copyFile(screenshot, new File(pathToSS + "udane.png"));
    }

    @Test
    public void checkSession() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("haslo")).sendKeys("admin");
        driver.findElement(By.id("zaloguj")).click();
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        screenshot = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        assertNotNull(screenshot);

        Set<Cookie> session = driver.manage().getCookies();
        Cookie sesja;
        for(Cookie c : session){
            if(c.toString().contains("PHPSESSID")){
                System.out.print("Lol");
                Cookie session_id = driver.manage().getCookieNamed("PHPSESSID");
                assertEquals(session_id.getValue().length() > 0, true);
            }
        }
            FileUtils.copyFile(screenshot, new File(pathToSS + "sesja.png"));

    }

    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}