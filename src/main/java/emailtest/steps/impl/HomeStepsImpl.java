package emailtest.steps.impl;

import emailtest.pageobject.HomePage;
import emailtest.steps.HomeSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomeStepsImpl implements HomeSteps {
    private final WebDriver webDriver;
    private final HomePage homePage;

    @Autowired
    public HomeStepsImpl(WebDriver webDriver, HomePage homePage) {
        this.webDriver = webDriver;
        this.homePage = homePage;
        PageFactory.initElements(webDriver, homePage);
    }

    @Override
    @Step
    public void inLogin() {
        homePage.clickButtonLogin();
    }

    @Override
    @Step
    public void toUrlPage() {
        webDriver.get(homePage.URL);
    }

    @Override
    public void initPage() {
        PageFactory.initElements(webDriver, homePage);
    }
}
