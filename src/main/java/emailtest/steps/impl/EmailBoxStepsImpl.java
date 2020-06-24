package emailtest.steps.impl;

import emailtest.model.Email;

import static org.assertj.core.api.Assertions.*;
import emailtest.pageobject.EmailBoxPage;
import emailtest.steps.EmailBoxSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailBoxStepsImpl implements EmailBoxSteps {
    private final WebDriver webDriver;
    private final EmailBoxPage emailBoxPage;

    @Autowired
    public EmailBoxStepsImpl(WebDriver webDriver, EmailBoxPage emailBoxPage) {
        this.webDriver = webDriver;
        this.emailBoxPage = emailBoxPage;
        PageFactory.initElements(webDriver, emailBoxPage);
    }

    @Override
    public void openUserAccountMenu() {
        emailBoxPage.openUserAccountMenu();
    }

    @Override
    @Step
    public void checkAccountNameDisplayed(String login) {
        assertThat(emailBoxPage.getStringUserAccountName()).isEqualTo(login);
    }

    @Override
    @Step
    public void openNewEmail() {
        emailBoxPage.writeButton();
    }

    @Override
    @Step
    public void fillEmailReceiver(String receiver) {
        emailBoxPage.fillReceiver(receiver);
    }

    @Override
    @Step
    public void fillEmailSubject(String subject) {
        emailBoxPage.fillSubject(subject);
    }

    @Override
    @Step
    public void fillEmailMessage(String message) {
        emailBoxPage.fillMessage(message);
    }


    @Override
    @Step
    public void checkFormNewEmailDisplayed() {
        assertThat(emailBoxPage.isFormNewEmailDisplayed()).isEqualTo(true);
    }

    @Override
    public void openDrafts() {
        emailBoxPage.openDrafts();
    }

    @Override
    public void openSentEmails() {
        emailBoxPage.openSent();
    }

    @Override
    public void openLastEmail() {
        emailBoxPage.openLastEmail();
    }

    @Override
    @Step
    public void checkSaveEmailSuccess(Email email) {
        //TODO
//        System.out.println(emailBoxPage.getStringFormReceiver());
        assertThat(emailBoxPage.getStringFormSubject()).isEqualTo(email.getSubject());
        assertThat(emailBoxPage.getStringFormMessage()).isEqualTo(email.getMessage());
//        equalsEmailValue(email);
    }

//    @Override
//    @Step
//    public void equalsEmailValue(Email email) {
//    }

    @Override
    @Step
    public void sendEmail() {
        emailBoxPage.sendEmail();
    }

    @Override
    @Step
    public void checkSendEmailSuccess(Email email) {
        assertThat(emailBoxPage.getStringSubject()).isEqualTo(email.getSubject());
        assertThat(emailBoxPage.getStringMessage()).isEqualTo(email.getMessage());
    }

    @Override
    public void toUrlPage() {
        webDriver.get(emailBoxPage.URL);
    }

    @Override
    public void initPage() {
        PageFactory.initElements(webDriver, emailBoxPage);
    }

    @Override
    @Step
    public void logout() {
        emailBoxPage.openUserAccountMenu();
        emailBoxPage.clickLogout();
    }
}
