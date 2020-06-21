package emailtest.pageobject;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Data
@Component
public class HomePage extends BasePage{
    @FindBy(xpath = "//span[text()='Войти']/parent::a")
    private WebElement buttonLogin;

    public void clickButtonLogin(){
        buttonLogin.click();
    }
}
