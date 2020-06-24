package emailtest.pageobject;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PageManager {
    private final HomePage homePage;
    private final LoginPage loginPage;
    private final EmailBoxPage emailBoxPage;

    @Autowired
    public PageManager(HomePage homePage, LoginPage loginPage, EmailBoxPage emailBoxPage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.emailBoxPage = emailBoxPage;
    }
}
