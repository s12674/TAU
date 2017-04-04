package com.pjatk.sellenium;

/**
 * Created by Mateusz on 03.04.2017.
 */

    import org.apache.commons.io.FileUtils;
    import org.junit.AfterClass;
    import org.junit.Before;
    import org.junit.BeforeClass;
    import org.junit.Test;
    import org.openqa.selenium.*;
    import org.openqa.selenium.chrome.ChromeDriver;

    import java.io.File;
    import java.io.IOException;
    import java.util.List;
    import java.util.concurrent.TimeUnit;

    import static org.junit.Assert.assertEquals;
    import static org.junit.Assert.assertNotNull;


public class SiteTest {
    private static OsValidator osValidator;
    private static WebDriver driver;
    private static String pathToSS;
    WebElement element;
    File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
    @BeforeClass
    public static void driverSetup() {
        OsValidator.lol();
        if(OsValidator.isWindows()){
            System.setProperty("webdriver.chrome.driver", "D:\\PJWSTK\\chromedriver.exe");
        }
        // ChromeDrirver, FireforxDriver, ...
        else{
            System.setProperty("webdriver.chrome.driver", "chromedriver");
        }
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Before
    public void setUp() throws Exception {
        if(OsValidator.isWindows()){
            pathToSS = "D:\\PJWSTK\\TAU\\SS\\";
        }
        else{
            pathToSS = "/SS/";
        }
        driver.manage().deleteAllCookies();
        driver.manage().getCookies().clear();
    }

    @Test
    public void javascriptTest() throws IOException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/index.php");
        List<WebElement> divs = driver.findElements(By.tagName("div"));
        List<WebElement> inputs = (List<WebElement>) ((JavascriptExecutor)driver).executeScript(
                "var labels = arguments[0], inputs = []; for (var i=0; i < labels.length; i++){" +
                        "inputs.push(document.getElementById(labels[i].getAttribute('for'))); } return inputs;", divs);

        assertEquals(inputs.size(), 5);
        assertEquals(divs.size(), 5);

    }
    @Test(expected = org.openqa.selenium.WebDriverException.class)
    public void jQueryTest() throws IOException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/index.php");
        WebElement element = (WebElement) ((JavascriptExecutor)driver).executeScript("return $('.lol)[0]");
    }

    @Test
    public void index() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/index.php");
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File(pathToSS + "glowna.png"));
    }

    @Test
    public void loginPage() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/index.php");
        driver.findElement(By.id("logowanie")).click();
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        assertNotNull(screenshot);
        FileUtils.copyFile(screenshot, new File(pathToSS + "panel.png"));
    }

    @Test
    public void loginFailed() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        driver.findElement(By.name("user")).sendKeys("wronglogin");
        driver.findElement(By.name("haslo")).sendKeys("wronglogin");
        driver.findElement(By.id("zaloguj")).click();
        screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        assertNotNull(screenshot);
        FileUtils.copyFile(screenshot, new File(pathToSS + "nieudane.png"));
    }

    @Test
    public void loginPassed() throws IOException, InterruptedException {
        driver.get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        driver.findElement(By.name("user")).sendKeys("admin");
        driver.findElement(By.name("haslo")).sendKeys("admin");
        driver.findElement(By.id("zaloguj")).click();
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
        FileUtils.copyFile(screenshot, new File(pathToSS + "sesja.png"));
    }







    @AfterClass
    public static void cleanp() {
        driver.quit();
    }
}