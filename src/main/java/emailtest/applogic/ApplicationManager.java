package emailtest.applogic;

import emailtest.model.Email;
import emailtest.model.User;
import org.springframework.stereotype.Component;

@Component
public interface ApplicationManager {
    void loginAs(User user);

    void checkLoginSuccess(User user);

    void fillEmailAndSave(Email email);

    void checkSave(Email email);

    void fillEmailAndSend(Email email);

    void checkSend(Email email);

    void logout();

    void checkLogout();
}
