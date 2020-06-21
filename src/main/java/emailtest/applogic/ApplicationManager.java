package emailtest.applogic;

import emailtest.model.Email;
import emailtest.model.User;
import org.springframework.stereotype.Component;

@Component
public interface ApplicationManager {
    void inFormLogin();

    void loginAs(User user) throws InterruptedException;

    void writeEmail(Email email) throws InterruptedException;
}
