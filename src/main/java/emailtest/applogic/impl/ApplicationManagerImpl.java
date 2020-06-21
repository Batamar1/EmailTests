package emailtest.applogic.impl;

import emailtest.applogic.ApplicationManager;
import emailtest.model.Email;
import emailtest.model.User;
import emailtest.pageobject.EmailBoxPage;
import emailtest.pageobject.HomePage;
import emailtest.pageobject.LoginPage;
import emailtest.pageobject.PageManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ApplicationManagerImpl implements ApplicationManager {
    private WebDriver driver;
    private PageManager pageManager;

    @Autowired
    public ApplicationManagerImpl(WebDriver driver, PageManager pageManager) {
        this.driver = driver;
        this.pageManager = pageManager;
    }

    @Override
    public void inFormLogin() {
        driver.get("https://mail.yandex.ru/");
        HomePage homePage = pageManager.getHomePage();
        PageFactory.initElements(driver, homePage);
        homePage.clickButtonLogin();
    }

    @Override
    public void loginAs(User user) throws InterruptedException {
        LoginPage loginPage = pageManager.getLoginPage();
        PageFactory.initElements(driver, loginPage);
        loginPage.loginAs(user);

    }

    @Override
    public void writeEmail(Email email) throws InterruptedException {
        EmailBoxPage emailBoxPage = pageManager.getEmailBoxPage();
        PageFactory.initElements(driver, emailBoxPage);
        emailBoxPage.writeButton();
        for(String receiver : email.getReceivers()){
            emailBoxPage.inputReceiver(receiver);
        }
        emailBoxPage.inputSubject(email.getSubject());
        emailBoxPage.inputText(email.getText());
        Thread.sleep(10000);
    }
}
