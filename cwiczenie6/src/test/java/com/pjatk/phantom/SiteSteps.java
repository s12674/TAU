package com.pjatk.phantom;

import org.jbehave.core.annotations.Given;
import org.jbehave.core.annotations.Then;
import org.jbehave.core.annotations.When;

/**
 * Created by Mateusz on 10.04.2017.
 */
public class SiteSteps {
    private final Pages pages;

    public SiteSteps(Pages pages) {
        this.pages = pages;
    }

    @Given("user is on login form page")
    public void userOnLoginFormPage() {
        pages.loginform().open();
    }
    @Given("user is on Home page")
    public void userOnHomePage() {
        pages.homepage().open();
    }

    @Given("Users is accessing site for the first time")
    public void firstTime(){
        pages.loginform().refresh();
    }

    @When("user inserts login: $loginKey in input with name: $loginName")
    public void userInsertsLoginData(String loginName, String loginKey) {
        pages.loginform().setUser(loginKey, loginName);
    }

    @Then("user inserts password: $passwordKey in input with name: $passwordNane")
    public void userInsertsPasswordData(String passwordName, String passwordKey) {
        pages.loginform().setPassword(passwordKey, passwordName);
    }

    @When("user clicks button with id: $buttonId")
    public void userClicksButton(String buttonId) {
        pages.loginform().submitClick(buttonId);
    }

    @Then("site displays failed login text in div with id: $failedDivId")
    public void siteDisplaysFailedLoginText(String failedDivId) {
        pages.loginform().getFailedDataId(failedDivId);
    }

    @Then("site message after trying to log: $successDivId")
    public void siteDisplaysSuccessLoginText(String successDivId) {
        pages.loginform().getSuccessDataId(successDivId);
    }

    @Then("site contains link with text: $logoutText")
    public void siteContainsLogoutTextLink(String logoutText) {
        pages.loginform().getLogout(logoutText);
    }

    @When("user clicks on link with text: $homePageText")
    public void userClicksOnHomePageLinkText(String homePageText) {
        pages.loginform().backLinkHome(homePageText);
    }

    @Then("user clicks on link with text: $loginLink")
    public void loginLink(String loginLink) {
        pages.homepage().loginLink(loginLink);
    }


    @Then("check if session is good: $sessionLengthBool")
    public void sessionCheck(Boolean $sessionLengthBool) {
        pages.loginform().sessionCheck($sessionLengthBool);
    }
}
