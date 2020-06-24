package emailtest.steps;

import emailtest.model.User;
import org.springframework.stereotype.Component;

@Component
public interface LoginSteps extends BaseSteps{
    void initPage();
    void writeLogin(String login);
    void writePassword(String password);
    void inputSubmit();
    void checkLogout();
}
