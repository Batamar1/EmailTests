package emailtest.pageobject;

import emailtest.model.User;
import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginPage extends BasePage{
    @Getter
    public final String URL = "";

    @FindBy(name = "login")
    WebElement inputLogin;

    @FindBy(name = "passwd")
    WebElement inputPassword;

    @FindBy(xpath = "//span[text()='Войти']/parent::button")
    WebElement submitButton;

    @Autowired
    public LoginPage(WebDriver webDriver) {
        super(webDriver);
    }

    public void fillLogin(String login){
        super.waitUntilElementVisible(inputLogin).sendKeys(login);
    }

    public void fillPassword(String password){
        super.waitUntilElementVisible(inputPassword).sendKeys(password);
    }

    public void inputSubmit(){
        super.waitUntilElementVisible(submitButton).click();
    }

    public void loginAs(User user){
        fillLogin(user.getLogin());
        inputSubmit();
        fillPassword(user.getPassword());
        inputSubmit();
    }
}
