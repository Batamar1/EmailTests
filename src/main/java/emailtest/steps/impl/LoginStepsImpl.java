package emailtest.steps.impl;

import static org.assertj.core.api.Assertions.*;
import emailtest.pageobject.LoginPage;
import emailtest.steps.LoginSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginStepsImpl implements LoginSteps{
    WebDriver webDriver;
    LoginPage loginPage;

    @Autowired
    public LoginStepsImpl(WebDriver webDriver, LoginPage loginPage) {
        this.webDriver = webDriver;
        this.loginPage = loginPage;
        PageFactory.initElements(webDriver, loginPage);
    }


    @Override
    @Step
    public void toUrlPage() {
        webDriver.get(loginPage.URL);
    }

    @Override
    public void initPage() {
        PageFactory.initElements(webDriver, loginPage);
    }

    @Override
    @Step
    public void writeLogin(String login) {
        loginPage.fillLogin(login);
    }

    @Override
    @Step
    public void writePassword(String password) {
        loginPage.fillPassword(password);
    }

    @Override
    @Step
    public void inputSubmit() {
        loginPage.inputSubmit();
    }



    @Override
    @Step
    public void checkLogout() {
        assertThat(webDriver.getTitle()).isEqualTo("Авторизация");
    }
}
