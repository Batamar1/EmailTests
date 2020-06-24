package emailtest.steps;

import emailtest.model.Email;
import org.springframework.stereotype.Component;

@Component
public interface EmailBoxSteps extends BaseSteps{
    void openUserAccountMenu();
    void checkAccountNameDisplayed(String login);
    void openNewEmail();
    void fillEmailReceiver(String receiver);
    void fillEmailSubject(String subject);
    void fillEmailMessage(String message);
    void checkFormNewEmailDisplayed();
    void checkSaveEmailSuccess(Email email);
    void openDrafts();
    void openSentEmails();
    void openLastEmail();
    //void equalsEmailValue(Email email);
    void sendEmail();
    void checkSendEmailSuccess(Email email);
    void logout();
}
