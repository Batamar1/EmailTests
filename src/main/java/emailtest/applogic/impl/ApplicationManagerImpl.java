package emailtest.applogic.impl;

import emailtest.applogic.ApplicationManager;
import emailtest.model.Email;
import emailtest.model.User;
import emailtest.pageobject.PageManager;
import emailtest.steps.manager.StepsManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ApplicationManagerImpl implements ApplicationManager {
    private final WebDriver driver;
    private final PageManager pageManager;
    private final StepsManager stepsManager;

    @Autowired
    public ApplicationManagerImpl(WebDriver driver, PageManager pageManager, StepsManager stepsManager) {
        this.driver = driver;
        this.pageManager = pageManager;
        this.stepsManager = stepsManager;
    }

    @Override
    public void loginAs(User user){
        log.info("LoginAs");
        stepsManager.getHomeSteps().toUrlPage();
        stepsManager.getHomeSteps().inLogin();
        stepsManager.getLoginSteps().initPage();
        stepsManager.getLoginSteps().writeLogin(user.getLogin());
        stepsManager.getLoginSteps().inputSubmit();
        stepsManager.getLoginSteps().writePassword(user.getPassword());
        stepsManager.getLoginSteps().inputSubmit();
    }

    @Override
    public void checkLoginSuccess(User user) {
        stepsManager.getEmailBoxSteps().openUserAccountMenu();
       // stepsManager.getEmailBoxSteps().checkAccountNameDisplayed(user.getLogin());
    }

    @Override
    public void fillEmailAndSave(Email email) {
        openNewEmailForm();
        fillEmailForm(email);
    }

    @Override
    public void checkSave(Email email){
        stepsManager.getEmailBoxSteps().openDrafts();
        try{Thread.sleep(2000);}
        catch (InterruptedException e){e.printStackTrace();}
        stepsManager.getEmailBoxSteps().openLastEmail();
        stepsManager.getEmailBoxSteps().checkSaveEmailSuccess(email);
    }

    @Override
    public void fillEmailAndSend(Email email) {
        openNewEmailForm();
        fillEmailForm(email);
        stepsManager.getEmailBoxSteps().sendEmail();
    }

    @Override
    public void checkSend(Email email) {
        stepsManager.getEmailBoxSteps().openSentEmails();
        try{Thread.sleep(2000);}
        catch (InterruptedException e){e.printStackTrace();}
        stepsManager.getEmailBoxSteps().openLastEmail();
        stepsManager.getEmailBoxSteps().checkSendEmailSuccess(email);
    }

    private void openNewEmailForm(){
        stepsManager.getEmailBoxSteps().openNewEmail();
        stepsManager.getEmailBoxSteps().checkFormNewEmailDisplayed();
    }

    private void fillEmailForm(Email email){
        for(String receiver : email.getReceivers()) stepsManager.getEmailBoxSteps().fillEmailReceiver(receiver);
        stepsManager.getEmailBoxSteps().fillEmailSubject(email.getSubject());
        stepsManager.getEmailBoxSteps().fillEmailMessage(email.getMessage());
    }

    @Override
    public void logout() {
        stepsManager.getEmailBoxSteps().logout();
    }

    @Override
    public void checkLogout() {
        stepsManager.getLoginSteps().checkLogout();
    }
}
