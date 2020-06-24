package emailtest.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class HomePage extends BasePage{
    @Getter
    public final String URL = "https://mail.yandex.ru/";

    @FindBy(xpath = "//span[text()='Войти']/parent::a")
    private WebElement buttonLogin;

    @Autowired
    public HomePage(WebDriver webDriver) {
        super(webDriver);
    }

    public void clickButtonLogin(){
        super.waitUntilElementVisible(buttonLogin).click();
    }
}
