package emailtest.pageobject;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PageManager {
    private HomePage homePage;
    private LoginPage loginPage;
    private EmailBoxPage emailBoxPage;

    @Autowired
    public PageManager(HomePage homePage, LoginPage loginPage, EmailBoxPage emailBoxPage) {
        this.homePage = homePage;
        this.loginPage = loginPage;
        this.emailBoxPage = emailBoxPage;
    }
}
