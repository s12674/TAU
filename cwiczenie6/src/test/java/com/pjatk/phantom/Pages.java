package com.pjatk.phantom;

/**
 * Created by Mateusz on 10.04.2017.
 */

import org.jbehave.web.selenium.WebDriverProvider;
import com.pjatk.phantom.pages.HomeP;
import com.pjatk.phantom.pages.LoginP;

public class Pages {
    private WebDriverProvider driverProvider;

    private HomeP homePage;
    private LoginP loginPage;

    public Pages(WebDriverProvider driverProvider) {
        super();
        this.driverProvider = driverProvider;
    }

    public HomeP homepage() {
        if (homePage == null) {
            homePage = new HomeP(driverProvider);
        }
        return homePage;
    }

    public LoginP loginform() {
        if(loginPage == null) {
            loginPage = new LoginP(driverProvider);
        }
        return loginPage;
    }

}
