package emailtest.steps.manager;

import emailtest.steps.EmailBoxSteps;
import emailtest.steps.HomeSteps;
import emailtest.steps.LoginSteps;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Getter
@Component
public class StepsManager {
    private final EmailBoxSteps emailBoxSteps;
    private final HomeSteps homeSteps;
    private final LoginSteps loginSteps;

    @Autowired
    public StepsManager(EmailBoxSteps emailBoxSteps, HomeSteps homeSteps, LoginSteps loginSteps) {
        this.emailBoxSteps = emailBoxSteps;
        this.homeSteps = homeSteps;
        this.loginSteps = loginSteps;
    }
}
