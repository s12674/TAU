package com.pjatk.phantom.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

/**
 * Created by Mateusz on 10.04.2017.
 */
public class HomeP extends WebDriverPage {

    public HomeP(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/index.php");
        manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    public void loginLink(String loginLink) {
        WebElement e = findElement(By.id(loginLink));
        e.click();
    }
}
