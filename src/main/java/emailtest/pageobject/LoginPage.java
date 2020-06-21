package emailtest.pageobject;

import emailtest.model.User;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Data
@Component
public class LoginPage extends BasePage{

    @FindBy(name = "login")
    WebElement inputLogin;

    @FindBy(name = "passwd")
    WebElement inputPassword;

    @FindBy(xpath = "//span[text()='Войти']/parent::button")
    WebElement submitButton;

    public void loginAs(User user){
        inputLogin.sendKeys(user.getLogin());
        submitButton.click();
        inputPassword.sendKeys(user.getPassword());
        submitButton.click();
    }
}
