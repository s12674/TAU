package com.pjatk.phantom.pages;

import org.jbehave.web.selenium.WebDriverPage;
import org.jbehave.web.selenium.WebDriverProvider;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebElement;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import static org.junit.Assert.assertEquals;

/**
 * Created by Mateusz on 10.04.2017.
 */
public class LoginP extends WebDriverPage {
    public LoginP(WebDriverProvider driverProvider) {
        super(driverProvider);
    }

    public void open() {
        get("http://szuflandia.pjwstk.edu.pl/~s12674/WPR/projekt/projekt/logowanie.php");
        manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }
    public void refresh() {
        manage().deleteAllCookies();
    }
    public void setUser(String loginName, String loginKey) {
        WebElement e = findElement(By.name(loginName));
        e.sendKeys(loginKey);
    }

    public void setPassword(String passwordName, String passwordKey) {
        WebElement e = findElement(By.name(passwordName));
        e.sendKeys(passwordKey);
    }

    public void submitClick(String submitId) {
        WebElement e = findElement(By.id(submitId));
        e.click();
    }

    public String getFailedDataId(String failedDivId) {
        WebElement e = findElement(By.id(failedDivId));
        return e.getText();
    }

    public String getLogout(String text) {
        WebElement e = findElement(By.id(text));
        if(e.isDisplayed()) return e.getText();
        else return "Nope";

    }

    public void backLinkHome(String backToHomePageLink) {
        WebElement e = findElement(By.linkText(backToHomePageLink));
        e.click();
    }

    public Boolean sessionCheck(Boolean sessionId) {
        Boolean mark = false;
        Set<Cookie> session = manage().getCookies();
        Cookie sesja;
        for(Cookie c : session){
            if(c.toString().contains("PHPSESSID")){
                System.out.print("Lol");
                Cookie session_id = manage().getCookieNamed("PHPSESSID");
                assertEquals(session_id.getValue().length() > 0, true);
                mark = true;
            }
        }
        return mark;
    }

    public String getSuccessDataId(String successDivId) {
        WebElement e = findElement(By.id(successDivId));
        return e.getText();
    }
}
